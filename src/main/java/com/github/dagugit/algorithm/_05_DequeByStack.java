package com.github.dagugit.algorithm;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class _05_DequeByStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 思路
     * stack1用来push操作，stack2用来pop操作
     * 1、push时先看stack中是否还有元素，有压入statck1
     * 2、现将stack压入statck，stack2在pop
     *
     * @param node
     */
    public void push(int node) {
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        if(!stack2.empty()){
            return  stack2.pop();
        }
        return 0;
    }

    public static void main(String[] args) {
        _05_DequeByStack dequeByStack = new _05_DequeByStack();
        int pop = dequeByStack.pop();
        dequeByStack.push(1);
        dequeByStack.push(2);
        dequeByStack.push(3);
        System.out.println(dequeByStack.pop());;
        dequeByStack.push(4);
        System.out.println(dequeByStack.pop());;
        System.out.println(dequeByStack.pop());;
        System.out.println(dequeByStack.pop());;
    }
}
