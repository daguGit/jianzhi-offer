package com.github.dagugit.algorithm;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class _20_DefineStack {
    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;

    /**
     * 思路：
     * 1：本地维护一个栈
     * 2：push的时候记录最小值，并入栈
     * 3：pop
     * -A:当栈为空时，返回
     * -B：当栈顶元素==min时，直接pop，并更新最小值
     * -C：其他直接pop
     * 4：top：peek()
     * 5:min:返回最小值
     *
     * @param node
     */
    public void push(int node) {
        if (node < min) {
            min = node;
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.size() <= 0) {
            return;
        }
        if (stack.peek() == min) {
            stack.pop();
            List<Integer> integers = stack.subList(0, stack.size());
            Collections.sort(integers);
            min = integers.get(0);
            return;
        }
        stack.pop();

    }

    public int top() {
        if (stack.size() <= 0) {
            return 0;
        }
        return stack.peek();
    }

    public int min() {
        if (stack.size() <= 0) {
            return 0;
        }
        return this.min;
    }

    public static void main(String[] args) {
        _20_DefineStack defineStack = new _20_DefineStack();
        defineStack.push(3);
        defineStack.push(2);
        defineStack.push(1);
        defineStack.pop();
        System.out.println(defineStack.top());
        System.out.println(defineStack.min());


    }
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public _20_DefineStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push2(int x){
        stack1.push(x);
        if(stack2.isEmpty() || stack2.peek()>x)
            stack2.push(x);
        else
            stack2.push(stack2.peek());
    }

    public void pop2(){
        stack1.pop();
        stack2.pop();
    }

    public int top2(){
        return stack1.peek();
    }

    public int getMin2(){
        return stack2.peek();
    }
}
