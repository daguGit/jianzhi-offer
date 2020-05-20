package com.github.dagugit.algorithm;

/**
 * 变态跳台阶
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class _09_JumpFloorII {
    /**
     * 思路：
     * 1、f(n)=1+f(n-1)+f(n-2)+f(n-3)...+f(0)
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int sum =1;
        for(int i=1;i<target;i++){
            sum+=JumpFloorII(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        _09_JumpFloorII jumpFloorII = new _09_JumpFloorII();
        System.out.println(jumpFloorII.JumpFloorII(2));
        System.out.println(jumpFloorII.JumpFloorII(3));
        System.out.println(jumpFloorII.JumpFloorII(4));
    }
}
