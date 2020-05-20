package com.github.dagugit.algorithm;

/**
 * 斐波那契数列
 * <p>
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 */
public class _07_Fibonacci {
    /**
     * 思路：
     * 1、斐波那契数列后一项是前两项的和，利用这个性质，得到 f(n)=f(n-1)+f(n-2),从而递归循环
     * f(2)=f(1)+f(0)
     * f(3)=f(2)+f(1)
     * 2、递归截止标记是 f(0)、f(1)
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        _07_Fibonacci fibonacci = new _07_Fibonacci();
        System.out.println(fibonacci.Fibonacci(0));
        System.out.println(fibonacci.Fibonacci(1));
        System.out.println(fibonacci.Fibonacci(2));
        System.out.println(fibonacci.Fibonacci(3));
        System.out.println(fibonacci.Fibonacci(4));
        System.out.println(fibonacci.Fibonacci(5));
        System.out.println(fibonacci.Fibonacci(6));

    }
}
