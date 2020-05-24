package com.github.dagugit.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 最小的K个数
 * <p>
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class _29_GetLeastNumbers {
    /**
     * 思路：
     * 1、特殊情况
     * -A、input 为空，input.length==0 return null
     * -B、k<0||k>input.length return null
     * 2、将input排序，获得前k个
     * 思路2：
     * 部分选择
     * 堆排序
     * 快速排序
     * //TODO 看看其他方法
     * TODO 此问题需扩展
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if(input==null||input.length==0){
            return integers;
        }
        if(k<0||k>input.length){
            return integers;
        }
        Arrays.sort(input);
        for(int i=0;i<k&&i<input.length;i++){
            integers.add(input[i]);
        }
        return integers;
    }

    public static void main(String[] args) {
        _29_GetLeastNumbers getLeastNumbers = new _29_GetLeastNumbers();
        int[] arrays={2,3,1,5,3};
        ArrayList<Integer> integers = getLeastNumbers.GetLeastNumbers(arrays, 7);
        integers.stream().forEach(a->{
            System.out.println(a);
        });
    }
}
