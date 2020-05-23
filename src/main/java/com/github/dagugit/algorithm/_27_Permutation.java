package com.github.dagugit.algorithm;

import java.util.ArrayList;

/**
 * 字符串的排列
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class _27_Permutation {
    ArrayList list = new ArrayList<String>();

    /**
     * 思路
     * 1、特殊情况
     * -A:当str==null||str.length==0,return null;
     * 2、使用递归的思想 str的全排列等于 不断变化str[0]+sub(1,str.length)的全排列
     * 3、for 循环交换str的首字母与其他位置字母
     * 4、交换后递归 fn(str.sub(1,str.length))
     * 5、将将交换的字符交换回来
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] chars = str.toCharArray();
        fn(chars, 0, chars.length);
        return list;
    }

    private void fn(char[] chars, int i, int j) {
        if (i == chars.length) {
            list.add(new String(chars));
        }
        for (int t = i; t < chars.length; t++) {
            char c = chars[i];
            chars[i] = chars[t];
            chars[t] = c;
            fn(chars, i + 1, j);
            c = chars[i];
            chars[i] = chars[t];
            chars[t] = c;
        }
    }

    public static void main(String[] args) {
        _27_Permutation permutation = new _27_Permutation();
        ArrayList<String> abcd = permutation.Permutation("abcd");
        abcd.stream().forEach(a -> {
            System.out.println(a);
        });
    }
}
