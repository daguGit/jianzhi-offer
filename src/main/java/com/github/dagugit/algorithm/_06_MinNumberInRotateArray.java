package com.github.dagugit.algorithm;

/**
 * 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class _06_MinNumberInRotateArray {
    /**
     * 思路：
     * 1、考虑题目是一个非递减排序的数组，那么旋转之后第一个小于前面值的项因为数组的最小值；
     * 2、特殊情况：
     * -A：数组为空
     * -B：如果数组元素全相同，那返回第一个就行
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                return array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        _06_MinNumberInRotateArray minNumberInRotateArray = new _06_MinNumberInRotateArray();
        int[] a = {};
        int[] b = {1};
        int[] c = {1, 1};
        int[] d = {2, 3, 1};
        int[] e = {3, 4, 5, 2};
        System.out.println(minNumberInRotateArray.minNumberInRotateArray(a));
        System.out.println(minNumberInRotateArray.minNumberInRotateArray(b));
        System.out.println(minNumberInRotateArray.minNumberInRotateArray(c));
        System.out.println(minNumberInRotateArray.minNumberInRotateArray(d));
        System.out.println(minNumberInRotateArray.minNumberInRotateArray(e));

    }
}
