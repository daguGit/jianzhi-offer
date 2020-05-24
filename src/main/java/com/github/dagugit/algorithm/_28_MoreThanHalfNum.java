package com.github.dagugit.algorithm;

/**
 * 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class _28_MoreThanHalfNum {
    /**
     * 思路1:暴力解法
     * 1、声明map，统计数组中数字出现的个数
     * 2、统计map，输入超过数组长度一半的数字
     * <p>
     * 思路2：
     * 1、特殊情况
     * -A：array==null||array.length==0 return 0;
     * 2、记录数组第一个数的值和次数，依次遍历数组，
     * -A:若接下来的数字和记录的数字相同，则次数加一
     * -B:若接下来的数字和记录的数字不同，则次数减一
     * 3、当次数为零时，保存下一个数字，并将次数置为1
     * 4、若最后获得了一个次数大于1的数字，则判断这个数字是否符合要求。若没有得到这样一个数字，则返回0
     * （若一个数字的次数超过一半，则一定会在最后被得到；但是最后得到的数字，出现次数不一定超过一半如 4，4，1,2,4,3,3）
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum(int[] array) {
        //非法输入判断
        if (array == null || array.length <= 0) {
            return 0;
        }
        int times = 1;
        int number = array[0];
        //查看是否存在有可能次数大于数组长度一半的数字
        for (int i = 1; i < array.length; i++) {
            if (times <= 0) {
                number = array[i];
                times = 0;
            }
            if (array[i] == number) {
                times++;
            } else {
                times--;
            }
        }
//        判断该数字次数是否大于数组长度一半
        if (times > 0) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == number) {
                    count++;
                }
            }
            if (count > array.length / 2) {
                return number;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        _28_MoreThanHalfNum moreThanHalfNum = new _28_MoreThanHalfNum();
        int[] array ={1,2,3,2,2,2,5,4,2};//{4,4,1,2,4,3,3};
        System.out.println(moreThanHalfNum.MoreThanHalfNum(array));
    }
}
