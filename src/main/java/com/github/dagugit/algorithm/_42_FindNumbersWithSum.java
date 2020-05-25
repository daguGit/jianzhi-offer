package com.github.dagugit.algorithm;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class _42_FindNumbersWithSum {
    /**
     * 思路：
     * 其实主要思想是两个数的乘积要最小，那么这个时候我们就需要知道，当一个有序的序列，两个数相隔越远，最后得到的数最小。
     * 所以我们设定两个指针，分别从序列的两头出发。
     * <p>
     * 数列满足递增，设两个头尾两个指针i和j，
     * 若ai + aj == sum，就是答案（相差越远乘积越小）
     * 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
     * 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
     * O(n)
     */

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int length = array.length;
        int i = 0;
        int j = length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                break;
            }
            /*
            while(i < j && array[i] + array[j] > sum)
                j --;
            while(i < j && array[i] + array[j] < sum)
                i ++;
             */
            if (array[i] + array[j] > sum) {
                j--;
            }
            if (array[i] + array[j] < sum) {
                i++;
            }

        }
        return list;
    }

    public static void main(String[] args) {

    }
}
