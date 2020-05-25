package com.github.dagugit.algorithm;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * <p>
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class _41_FindContinuousSequence {
    /**
     * 思路1：
     * 使用暴力双层for循环的方法，因为是连续正数，所以最少包含两个，即 正数 n<=sum/2;
     * 1、for 循环开始节点 i=0;i<=n;j++
     * 2、for 循环 j 结束节点，j>i;j<n;j++
     * 3、计算 i~j 的和，等于sum，记录并输出
     * <p>
     * 思路2：
     *  TODO 这个思路想不到，待分析
     * 1、双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针
     * 2、根据窗口内值之和来确定窗口的位置和宽度。
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        // 存放结果
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();

        if (sum < 3) {
            return res;
        }

        // 两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1,phigh = 2;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                res.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
