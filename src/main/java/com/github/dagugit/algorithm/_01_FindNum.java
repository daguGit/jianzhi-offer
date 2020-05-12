package com.github.dagugit.algorithm;

/**
 * 二维数组中查找
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author Administrator
 */
public class _01_FindNum {
    /**
     * 思路：
     * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
     * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
     * 要查找数字比左下角数字小时，上移
     */
    public boolean find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        } else {
            int rowCount = array.length;
            int colCount = array[0].length;
            for (int i = rowCount - 1, j = 0; i >= 0 && j < colCount; ) {
                if (target == array[i][j]) {
                    return true;
                } else if (target < array[i][j]) {
                    i--;
                    continue;
                } else if (target > array[i][j]) {
                    j++;
                    continue;
                }
            }
            return false;
        }
    }

    /**
     * 双层for循环暴力解法；
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find2(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (target == array[i][j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        _01_FindNum findNum = new _01_FindNum();
        int target = 1;
        int[][] array = {{1, 2}, {2, 3}};
        boolean b = findNum.find(target, array);
        System.out.println(b);

    }
}