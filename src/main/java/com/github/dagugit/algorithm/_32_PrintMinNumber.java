package com.github.dagugit.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class _32_PrintMinNumber {
    /**
     * 思路1：
     * 暴力的方法：将数组全排列后，比较大小；
     * <p>
     * 思路2：
     * 借鉴网上的思路，这个思路很妙
     * 对于给定的2个数，a和b。如何确定两者之间的排序策略呢？我们可以发现这两者的排列为：ab,ba。
     * 我们最终目的是找到字典序最小的那个排列，所以我们肯定应该保持这种关系，从而决定是否交换顺序：
     * 1. 当ab < ba, a排在b的左边
     * 2. 当ab > ba, b排在a的左边
     * 3. 当ab = ba, 位置关系随意
     *
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strNumbers.length; i++) {
            sb.append(strNumbers[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("3".compareTo("321"));

    }
}
