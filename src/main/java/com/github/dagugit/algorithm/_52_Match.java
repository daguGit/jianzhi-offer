package com.github.dagugit.algorithm;

import java.util.regex.Pattern;

/**
 * 正则表达式匹配
 * <p>
 * TODO:待整理
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 */
public class _52_Match {
    /**
     * 思路：
     * 大致使用递归的思想
     * 1:特殊情况
     * -A:两个字符串都为空，返回true
     * -B：第一个字符串不空，第二个空，return false；第一个字符串空，第二个非空，不知道
     * 2：考虑匹配第一个字符，匹配成成功或失败，根据第二个字符是否为 *,分成以下两种情况
     * -A:下一个字符不为“*”，直接匹配当前字符；
     * --A1：如果配置成功(与当前字符相同，或者patteern的字符为".")，直接匹配下一步
     * --A2: 如果失败，return fasle
     * -B:下一个字符为“*”
     * --B1：当“*”匹配0个字符时，str不变，pattern直接后移两位
     * --B2：匹配一个或多个，str下移一个，pattern不变；（这里匹配1个或多个可以看成一种情况，因为：当匹配一个时，
     * 由于str移到了下一个字符，而pattern字符不变，就回到了上边的情况a；当匹配多于一个字符时，相当于从str的下一个字符继续开始匹配）
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                //模式后移2，视为x*匹配0个字符
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        //视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        //*匹配1个，再匹配str中的下一个
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }


    /**
     * 偷懒的方法
     * 思路：
     * 借用regex直接判断
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match2(char[] str, char[] pattern) {
        String s = new String(str);
        String pat = new String(pattern);
        boolean isMatch = Pattern.matches(pat, s);
        return isMatch;
    }

    public static void main(String[] args) {
        //串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是
        _52_Match match = new _52_Match();
        char[] str = {'a'};
//        char[] str = {'a'};
        char[] p = {'a', 'a', '*'};
//        char[] p = {'a','.','a'};
//        char[] p = {'.', '*'};
//        boolean match1 = match.match(str, p);
//        System.out.println(match1);
        boolean b = match.match(str, p);
        System.out.println(b);
    }
}
