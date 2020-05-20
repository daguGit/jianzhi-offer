package com.github.dagugit.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}
 * 及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class _64_MaxInWindows {
    /**
     * 思路：
     * 1：使用纯暴力的解法，构建两重for循环
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (num == null || num.length == 0) {
            return integers;
        }
        if (size == 0) {
            return integers;
        }
        if (size > num.length) {
            return integers;
        } else {
            for (int i = 0; i <= (num.length - size); i++) {
                integers.add(this.max(Arrays.copyOfRange(num, i, i + size)));
            }
        }
        return integers;
    }

    private int max(int[] num) {
        if (num.length != 0) {
            int max = num[0];
            for (int i = 0; i < num.length; i++) {
                if (max < num[i]) {
                    max = num[i];
                }
            }
            return max;
        }
        return Integer.MIN_VALUE;
    }
/*****************************以下是借鉴他人思路***************************************/
    /**
     * 题目：滑动窗口的最大值
     * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
     * 原则：
     * 对新来的元素k，将其与双端队列中的元素相比较
     * 1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
     * 2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
     * 队列的第一个元素是滑动窗口中的最大值
     */

    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null) {
            return ret;
        }
        if (num.length < size || size < 1) {
            return ret;
        }

        LinkedList<Integer> indexDeque = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }

        for (int i = size - 1; i < num.length; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }
            ret.add(num[indexDeque.getFirst()]);
        }
        return ret;
    }

    public static void main(String[] args) {
        _64_MaxInWindows maxInWindows = new _64_MaxInWindows();
        int[] array = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> integers = maxInWindows.maxInWindows(array, 3);
        for (int i : integers) {
            System.out.println(i);
        }
    }
}
