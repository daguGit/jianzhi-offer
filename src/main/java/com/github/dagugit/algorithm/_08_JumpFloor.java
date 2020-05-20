package com.github.dagugit.algorithm;

/**
 * 跳台阶
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class _08_JumpFloor {
    /**
     * 思路：
     * 1、设 n级台阶跳法为f(n),根据条件则 f(n)=f(n-1)+f(n-2)
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    public static void main(String[] args) {
        _08_JumpFloor jumpFloor = new _08_JumpFloor();

        System.out.println(jumpFloor.JumpFloor(0));
        System.out.println(jumpFloor.JumpFloor(1));
        System.out.println(jumpFloor.JumpFloor(2));
        System.out.println(jumpFloor.JumpFloor(5));
    }
}
