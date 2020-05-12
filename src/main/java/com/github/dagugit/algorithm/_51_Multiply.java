package com.github.dagugit.algorithm;

/**
 * 构建乘积数组
 * <p>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class _51_Multiply {
    /**
     * 思路：通过观察题目可知，B[n]的构成很有规律，进而
     * B[n]可以演化成如下矩阵相乘
     * 先求对角线下半边矩阵值，即B[n]的一部分，在求上半部分矩阵值
     * 1 A1 A2 A3********An-1 An
     * A0 1 A2 A3********An-1 An
     * A0 A1 1 A3********An-1 An
     * A0 A1 A2 1********An-1 An
     * ************************
     * A0 A1 A2 1******** 1   An
     * A0 A1 A2 1********An-1 1
     *
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        //求对角线下面的值
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        //求对角线上面的值
        int temp = 1;
        for (int j = A.length - 2; j >= 0; j--) {
            temp = temp * A[j + 1];
            B[j] = B[j] * temp;
        }
        return B;
    }

    /**
     * 暴力的解法：双层for循环
     *
     * @param A
     * @return
     */
    public int[] multiply2(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            double t = 1;
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    t = t * A[j];
                }
            }
            B[i] = (int) t;
        }
        return B;
    }

    public static void main(String[] args) {
        _51_Multiply multiply = new _51_Multiply();
        int[] A = {2, 3, 4};
        int[] multiply1 = multiply.multiply(A);
        for (int t : multiply1) {
            System.out.println(t);
        }
        System.out.println(multiply1.toString());
    }
}
