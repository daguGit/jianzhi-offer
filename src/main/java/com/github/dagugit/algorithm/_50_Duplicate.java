package com.github.dagugit.algorithm;

/**
 * 数组中重复的数字
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class _50_Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,
    //    so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * 思路：
     * 这里题目强调数组里的数组都在0-1的范围内；
     * 所以可以声明一个长度为lenth的boolean类型的数组来记录是否重复
     * 遍历数组，并置当前位置的 boolean数组为true；当遇到boolean数组为true的时候，即满足条件
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        boolean[] array = new boolean[length];
        if (numbers == null || numbers.length == 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (array[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            } else {
                array[numbers[i]] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _50_Duplicate duplicate = new _50_Duplicate();
        int[] numbers = {2, 1, 3, 1, 4};
        int length = 5;
        int[] duplication = new int[1];
        boolean b = duplicate.duplicate(numbers, length, duplication);
        System.out.println(b + "  " + duplication[0]);
    }
}
