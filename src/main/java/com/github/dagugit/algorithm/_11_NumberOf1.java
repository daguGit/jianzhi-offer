package com.github.dagugit.algorithm;

/**
 * 二进制中1的个数
 * <p>
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class _11_NumberOf1 {
    /**
     * 思路：
     * 1、调用Integer的API可获得 n 的二进制表示
     * 2、for循环统计即可
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _11_NumberOf1 numberOf1 = new _11_NumberOf1();
        numberOf1.NumberOf1(9);
        System.out.println(numberOf1.NumberOf1(8));
        System.out.println(numberOf1.NumberOf1(9));
    }
}
