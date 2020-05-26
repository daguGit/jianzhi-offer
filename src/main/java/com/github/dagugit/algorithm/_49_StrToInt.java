package com.github.dagugit.algorithm;

/**
 * 注：此题未完全通过测试用例，因为测试用例错误。-2147483649超过int表示最小值，测试用例错误
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * +2147483647, 1a33
 * 输出
 * 2147483647
 * 0
 */
public class _49_StrToInt {
    /**
     * 思路：
     * 1、特殊情况
     * -A：str==null||str.length=0 return 0;
     * 2、验证合法性
     * -A：第一个字符不是 + 或 -
     * --A1：包含字母符号
     * --A2：不包含字母符号，是否越界
     * -B；第一个字符是 + 或 -
     * --B1：去掉后不包含字母符号，是否越界
     * --B2：去掉后包含字母符号
     * 3、将字符串转换为数字
     *
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 第一个不是 + —
        if (str.charAt(0) != '+' && str.charAt(0) != '-') {
            //如果字符串包含字母返回0
            for (int i = 0; i < str.length(); i++) {
                if (!isNumChar(str.charAt(i))) {
                    return 0;
                }
            }
            return this.transferInt(str);
        }
        // 第一个是 + -
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            // 之后的字符串包含字母 return 0；
            for (int i = 1; i < str.length(); i++) {
                if (!isNumChar(str.charAt(i))) {
                    return 0;
                }
            }
            return this.transferInt(str);
        }
        return 0;
    }

    private int transferInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        //只含有符号标志位时，返回0
        if (str.length() == 1 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
            return 0;
        }
        //str以+开头
        if (str.charAt(0) == '+') {
            try {
                int num10 = 1;
                double sum = 0;
                for (int i = str.length() - 1; i >= 1; i--) {
                    sum += (str.charAt(i) - 48) * num10;
                    num10 = num10 * 10;
                }
                //验证越界
                if (sum > Integer.MAX_VALUE) {
                    return 0;
                }
                return (int) sum;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }

        }
        if (str.charAt(0) == '-') {
            try {
                int num10 = -1;
                int sum = 0;
                for (int i = str.length() - 1; i >= 1; i--) {
                    sum += (str.charAt(i) - 48) * num10;
                    num10 = num10 * 10;
                }
                if (sum >= Integer.MIN_VALUE) {
                    return (int) sum;
                }
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        //其他正常情况
        try {
            int num10 = 1;
            double sum = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                sum += (str.charAt(i) - 48) * num10;
                num10 = num10 * 10;
            }
            if (sum > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) sum;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isNumChar(char c) {
        if (c >= 48 && c <= 57) {
            return true;
        }
        return false;
    }

    public int StrToIntII(String str) {
        if (str.equals("") || str.length() == 0) {
            return 0;
        }
        char[] a = str.toCharArray();
        int fuhao = 0;
        if (a[0] == '-') {
            fuhao = 1;
        }
        int sum = 0;
        for (int i = fuhao; i < a.length; i++) {
            if (a[i] == '+') {
                continue;
            }
            if (a[i] < 48 || a[i] > 57) {
                return 0;
            }
            sum = sum * 10 + a[i] - 48;
        }
        return fuhao == 0 ? sum : sum * -1;
    }

    public static void main(String[] args) {
        _49_StrToInt strToInt = new _49_StrToInt();
        double i = strToInt.StrToIntII("-2147483649");
        System.out.println(i);
        int j = strToInt.StrToInt("+123");
        System.out.println(j);
        System.out.println(Integer.parseInt("-2147483649"));
    }
}
