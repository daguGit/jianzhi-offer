package com.github.dagugit.algorithm;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class _21_IsPopOrder {
    /**
     * 思路：
     * 1、声明一个辅助栈,声明 pushFlag=0、popFlag=0标记
     * 2、遍历弹出序列、入栈序列
     * -A、先入栈一个元素、pushFlag++
     * -B、如果栈顶元素不是popA[popFlag]当前值，入栈,pushFlag++;
     * -C、栈顶元素是popA[popFlag]当前值，pop,popFlag++
     * -D、执行B、C循环，直到 pushFlag < pushA.length 即最后入栈序列遍历完、，如果栈不空，返回false，否则返回true
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int popFlag = 0;
        int pushFlag = 0;

        if (stack.size() == 0) {
            stack.push(pushA[pushFlag]);
        }
        pushFlag++;
        //这里使用do-while循环，是为了当只有一个元素时，也能遍历一次
        do {
            while (stack.size() != 0 && pushFlag < pushA.length && stack.peek() != popA[popFlag]) {
                stack.push(pushA[pushFlag++]);
            }
            while (stack.size() != 0 && stack.peek() == popA[popFlag] && popFlag < popA.length) {
                stack.pop();
                popFlag++;
            }
        } while (pushFlag < pushA.length);
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        _21_IsPopOrder isPopOrder = new _21_IsPopOrder();
//        int[] pushA = {1, 2, 3, 4, 5};
//        int[] popA = {4, 3, 5, 1, 2};
        int[] pushA = {1};
        int[] popA = {1};
//        int [] popA = {4,5,3,2,1};
        boolean b = isPopOrder.IsPopOrder(pushA, popA);
        System.out.println(b);
    }
}
