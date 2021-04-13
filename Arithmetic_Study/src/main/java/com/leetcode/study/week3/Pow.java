package com.leetcode.study.week3;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
 * <p>
 * 输入：x = 2.00000, n = 10 输出：1024.00000
 * 输入：x = 2.00000, n = -2 输出：0.25000 解释：2^-2 = 1/(2^2) = 1/4 = 0.25
 */
public class Pow {
    // 注意 x^0 == 1; 技巧 x^10 = (x^5)^2
    public double myPow(double x, int n) {
        return n >= 0 ? doPow(x, n) : 1.0 / doPow(x, -n);
    }

    private double doPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = doPow(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        }
        return n % 2 == 0 ? v * v : v * v * x;
    }
}
