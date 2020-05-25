package com.github.dagugit.algorithm;

/**
 * 左旋转字符串
 * <p>
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class _43_LeftRotateString {

    /**
     * 思路1：
     * 直接使用字符串切割的方法
     * 1、特殊情况
     * -A:str==null return null
     * -B：str.length == 0 return str
     * -C: n<=0 return str
     * -D: n>str.length 另 n=n%str.length
     * 2、切割字符串，并拼接
     * <p>
     * 思路2：
     * 使用类似栈的方法,并调用其API
     *
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str, int n) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return str;
        }
        if (n <= 0) {
            return str;
        }
        if (n >= str.length()) {
            return LeftRotateString(str, n % str.length());
        }
        String pre = str.substring(0, n);
        String last = str.substring(n , str.length());
        return last + pre;
    }

    public static void main(String[] args) {
        _43_LeftRotateString leftRotateString = new _43_LeftRotateString();
        String abcXYZdef = leftRotateString.LeftRotateString("abcXYZdef", 3);
        System.out.println(abcXYZdef);

    }
}
