package com.github.dagugit.algorithm;

/**
 * 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class _53_IsNumeric {

    /**
     * 分为以下几种情况：
     * 1：含有e或E
     * -A：e或E的后面必须是数字，
     * -B：含有多个e或E，return false
     * 2：含有-或+
     * -A：之前没有出现或符号，name此符号前必须是e或E
     * -B：之前出现过符号，此时 char[i]中的i大于0，那么此符号前必须是e或E
     * 3：不能出现多个小数点
     * 4：其他符号
     */
    public boolean isNumeric(char[] str) {
        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                // e后面一定要接数字
                if (i == str.length - 1) {
                    return false;
                }
                // 不能同时存在两个e
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '-' || str[i] == '+') {
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                // 第二次出现+-符号，则必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                // 不合法字符
                return false;
            }
        }

        return true;
    }

    /**
     * @param str
     * @return
     */
    public boolean isNumeric2(char[] str) {
        try {
            double v = Double.parseDouble(new String(str));
        } catch (Exception e) {
            System.out.println(str + e.toString());
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _53_IsNumeric isNumeric = new _53_IsNumeric();
        String[] strs = {"+100", "5e2", "-123", "3.1416", "+100", "-1E-16", "12e", "1a3.14", "1.2.3", "+-5", "12e+4.3", "-.23", "-"};
        for (String s : strs) {
            System.out.println(s + "  " + isNumeric.isNumeric(s.toCharArray()));
        }
    }
}
