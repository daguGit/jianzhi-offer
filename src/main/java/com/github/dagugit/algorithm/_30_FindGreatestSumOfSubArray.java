package com.github.dagugit.algorithm;

/**
 * 连续子数组的最大和
 * <p>
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class _30_FindGreatestSumOfSubArray {
    /***
     * 思路1：
     * 暴力解法
     * 1、双层for循环 i、j 得到子序列，然后分别记录极值
     *
     * 思路2：
     * 不能记录以某个数开头的连续子数组和，那尝试记录以某个数结尾的的连续子数组和
     * 1、定义 currentSum、greatSum
     * 2、遍历数组: 分为以下几种情况
     * -A: 当前数组和数值小于0，抛弃当前数组，最大和不更新
     * -B: 当前数组和数值大于0，大于greatSum，更新greatSum
     * -C：当前数组和数值大于0，小于greatSum，不更新
     *
     * 思路3：
     * 动态规划
     * //TODO
     *
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        if (len == 0){
            return 0;
        }
        int currentsum = array[0];
        int greatsetsum = array[0];
        for(int i=1;i<array.length;i++){
            if(currentsum > 0){
                currentsum += array[i];
            }else{
                currentsum = array[i];
            }
            if(currentsum > greatsetsum){
                greatsetsum  = currentsum;
            }
        }
        return greatsetsum;
    }

    public static void main(String[] args) {
        _30_FindGreatestSumOfSubArray findGreatestSumOfSubArray = new _30_FindGreatestSumOfSubArray();
        int[] array={-1,-3,-4,-1};
        int i = findGreatestSumOfSubArray.FindGreatestSumOfSubArray(array);
        System.out.println(i);
    }
}
