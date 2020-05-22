package com.github.dagugit.algorithm;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class _19_PrintMatrix {
    /**
     * 思路：
     * 1、特殊情况
     * -A:当matrix为空的时候，直接返回
     * 2:、按照要求遍历
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return integers;
        }
        int high = matrix.length;
        int width = matrix[0].length;
        //表示转了几圈
        int start = 0;
        while ((start * 2 < high) && (start * 2 < width)) {
            //左->右
            for (int i = start; i < width - start; i++) {
                integers.add(matrix[start][i]);
            }
            //上->下
            //只有中间还有元素时，才遍历
            if (high - start - start >= 1) {
                for (int j = start + 1; j < high - start; j++) {
                    integers.add(matrix[j][width - 1 - start]);
                }
            }
            //右->左
            if ((width - 1 - start - start >= 1) && (high - 1 - start - start >= 1)) {
                for (int m = width - start - 2; m >= start; m--) {
                    integers.add(matrix[high - start - 1][m]);
                }
            }
            //下->上
            if ((high - start - start > 1) && (width - 1 - start - start >= 1)) {
                for (int n = high - 2 - start; n > start; n--) {
                    integers.add(matrix[n][start]);
                }
            }
            start++;
        }

        return integers;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix = { { 6}};
        _19_PrintMatrix printMatrix = new _19_PrintMatrix();
        ArrayList<Integer> integers = printMatrix.printMatrix(matrix);
        integers.stream().forEach(a -> {
            System.out.println(a);
        });
    }
}
