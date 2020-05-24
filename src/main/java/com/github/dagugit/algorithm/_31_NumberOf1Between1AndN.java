package com.github.dagugit.algorithm;


/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class _31_NumberOf1Between1AndN {
    /**
     * 思路1:
     * 1、将数字转换成字符串统计里面 1 的个数
     * -A:
     * TODO 看看还有没有其他办法
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count =0;
        for(int i=1;i<=n;i++){
            String string = i+"";
            for(int j=0;j<string.length();j++){
                if(string.charAt(j)=='1'){
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        _31_NumberOf1Between1AndN numberOf1Between1AndN = new _31_NumberOf1Between1AndN();
        System.out.println(numberOf1Between1AndN.NumberOf1Between1AndN_Solution(13));
    }
}
