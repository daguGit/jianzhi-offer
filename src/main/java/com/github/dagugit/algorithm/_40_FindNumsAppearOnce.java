package com.github.dagugit.algorithm;

/**
 * 数组中只出现一次的数字
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class _40_FindNumsAppearOnce {
    /**
     * 思路1
     * 传统方法，使用map统计
     * 1、使用map统计每个数字出现的次数
     * 2、遍历map，将两个出现一次的数字输出
     * <p>
     * 思路2：本文使用此思路
     * 使用 位 的方法
     * 1、特殊情况
     * -A、当array==null时，return；
     * -B、当array.length<=1时，return；
     * 2、题目中只有两个出现一次，其他都出现了两次，所以可以使用异或的方式
     * 3、遍历数组 异或数组中的值，得到 flag
     * 4、flag 是这两个出现一次数值的异或结果，找到flag 的二进制中一个不为1的标记位 index
     * 5、使用index将数组分成两部分使用异或，通过异或的交换律，即可得到结果
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null) {
            return;
        }
        if (array.length <= 1) {
            return;
        }
        int flag = array[0];
        for (int i = 1; i < array.length; i++) {
            flag = flag ^ array[i];
        }

        //找到其第一个为1的位
        int index = 0;
        for (; index < 32; index++) {
            if (((flag >> index) & 1) == 1) {
                break;
            }
        }

        num1[0] = 0;
        num2[0] = 0;
        for (int num : array) {
            //按照该位是0还是1将数组分成两部分,分别异或
            if (((num >> index) & 1) == 1) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    public static void main(String[] args) {

    }
}
