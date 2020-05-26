package com.github.dagugit.algorithm;

/**
 * 求1+2+3+...+n
 * <p>
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class _47_Sum {
    /***
     * 思路：
     * 1、含有子问题？递归
     *
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        _47_Sum sum = new _47_Sum();
        int i = sum.Sum_Solution(4);
        System.out.println(i);
    }

}
