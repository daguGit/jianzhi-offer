package com.github.dagugit.algorithm;

/**
 * 第一个只出现一次的字符
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class _34_FirstNotRepeatingChar {
    /**
     * 链接：_2020_05_16_FirstAppearingOnce.java
     * 思路1：
     * 比较传统的思路
     * 1、声明一个map，统计str中每个字符出现的个数
     * 2、遍历str，找到第一个只出现一次的字符
     * <p>
     * 思路2：
     * 1、特殊情况
     * -A、str==null||str。length==0 return -1
     * 2、声明一256长度的数组 array，并将初始值置为-1
     * 3、遍历str，将当前字符c放入数组位置
     * -A：当数组值==-1时，将数组元素置为c在str中的位置
     * -B：当数组值>=0将数组元素置为 -2，表示此字符 c 出现了多次
     * 4、遍历数组array，找到值>=0，且值最小的，返回,否则返回-1；
     *
     * @param str
     * @return
     */
    //现在只实现思路2
    int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] array = new int[256];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //第一次出现时，将位置赋值
            if (array[c] == -1) {
                array[c] = i;
            } else if (array[c] >= 0) {
                //多次出现时，赋值成-2
                array[c] = -2;
            }
        }
        int min = Integer.MAX_VALUE;
        char c = '\0';
        for (int i = 0; i < array.length; i++) {
            //找到数组中含有位置，且位置最靠前的元素
            if (array[i] >= 0 && array[i] < min) {
                min = array[i];
                c = (char) i;
            }
        }
        if (c == '\0') {
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        _34_FirstNotRepeatingChar firstNotRepeatingChar = new _34_FirstNotRepeatingChar();

        int google = firstNotRepeatingChar.FirstNotRepeatingChar("google");
        System.out.println(google);
    }
}
