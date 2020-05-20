package com.github.dagugit.algorithm;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class _13_ReOrderArray {
    /**
     * 思路：
     * 1、声明另外的数组，先后遍历两次数组，第一次将奇数放进去、第二次将偶数放进去
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        int[] array2 = Arrays.copyOfRange(array, 0, array.length);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                array2[count] = array[i];
                count++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array2[count] = array[i];
                count++;
            }
        }
        array = array2;
        Arrays.stream(array).forEach(a -> {
            System.out.println(a);
        });
    }

    /**
     * 冒泡法的思路
     *
     * @param array
     */
    public void reOrderArray2(int[] array) {
        if (array.length == 0) {
            System.out.println("error");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if ((array[j] & 1) == 0 && (array[j + 1] & 1) != 0) {
                    int m = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = m;
                }
            }
        }
    }

    public static void main(String[] args) {
        _13_ReOrderArray reOrderArray = new _13_ReOrderArray();
        int[] array = {1, 2, 3, 4, 5, 6};
        reOrderArray.reOrderArray(array);
    }
}
