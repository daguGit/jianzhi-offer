package com.github.dagugit.algorithm;

/**
 * 数值的整数次方
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class _12_Power {
    /**
     * 思路：
     * 1、特殊情况
     * -A:base==0
     * -B:exponent==0
     * -C:base 为负数,exponent 为负数
     * 2、for循环 另base乘以exponent次
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        double t = 1;
        //base<0&&exponent<0
        if (base < 0 && exponent < 0) {
            for (int i = 0; i < Math.abs(exponent); i++) {
                t *= base;
            }
            return 1 / t;
        }
        //base<0&&exponent>0
        if (base < 0 && exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                t *= base;
            }
            return t;
        }
        //base>0&&exponent<0
        if (base > 0 && exponent < 0) {
            for (int i = 0; i < Math.abs(exponent); i++) {
                t *= base;
            }
            return 1 / t;
        }
        //base>0&&exponent>0
        if (base > 0 && exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                t *= base;
            }
            return t;
        }
        return 0;
    }

    public static void main(String[] args) {
        _12_Power power = new _12_Power();
        double power1 = power.Power(-2, -3);
        System.out.println(power1);
    }
}
