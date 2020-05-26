package com.github.dagugit.algorithm;

/**
 * 剪绳子
 * <p>
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 示例1
 * 输入 8
 * 输出 18
 */
public class _67_CutRope {
    /**
     * 思路：
     * --没想到咋解，借鉴他人思路
     * 用动态规划自下而上的计算，先算出n为1、2、3。。的最大乘积，知道小的以后在去算更大的乘积。
     * 比如n为4时候最大的可能只能在1*3,2*2之间取得；n为5时，只能在f(1)*f(4),f(2)*f(3)之间取得,
     * 而f(2),f(3),f(4)之前均已经求出。
     * <p>
     * 极值问题
     * 是否含有子问题 f(8)与f(7)、f(6)。。。有关系？
     * 子问题重复？
     * 状态方程？
     * --状态 target，绳子的长度
     * --选择 每个状态可以进行什么选择，即状态与子状态之间的联系
     * for (int j = 1; j <= i / 2; j++) { f(i)=Max(f(j)+f(i-j)})
     *
     * @param target
     * @return
     */
    public int cutRope(int target) {
        return (int) maxLen(target);
    }

    /**
     *  * @param len绳子的长度
     *  * @return
     *  
     */
    private double maxLen(int len) {
        if (len < 2) {
            return 0;
        }
        if (len == 2) {
            return 1;
        }
        if (len == 3) {
            return 2;
        }
        // lenCut[i]表示长度为i个的最优解 lenCut[3]比较特殊
        double lenCut[] = new double[len + 1];
        lenCut[0] = 0;
        lenCut[1] = 1;
        lenCut[2] = 2;
        lenCut[3] = 3;
        //初始化到3是因為3>1*2，其本身比分割的大，所以當分割比3大的數字時候，如5可以分成2，3，3就不繼續往下分割了

        for (int i = 4; i <= len; i++) {
            double max = 0;
            for (int j = 1; j <= i / 2; j++) {
                double temp = lenCut[j] * lenCut[i - j];
                if (max < temp) {
                    max = temp;
                }
            }
            lenCut[i] = max;
        }

        return lenCut[len];
    }

    public static void main(String[] args) {
        _67_CutRope cutRope = new _67_CutRope();
        int i = cutRope.cutRope(2);

        System.out.println(i);
    }
}
