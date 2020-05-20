package com.github.dagugit.algorithm;

/**
 * 矩形覆盖
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * <p>
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class _10_RectCover {
    /**
     * 思路
     * 采用分治法策略
     * 1、参考跳台阶
     * -A:当最后一块竖放 f(n)=f(n-1)
     * -B:当最后两块横放 f(n)=f(n-2)
     * 所以 f(n)=f(n-1)+f(n-2)
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }

    public static void main(String[] args) {
        _10_RectCover rectCover = new _10_RectCover();
        System.out.println(rectCover.RectCover(3));
        System.out.println(rectCover.RectCover(4));
    }
}
