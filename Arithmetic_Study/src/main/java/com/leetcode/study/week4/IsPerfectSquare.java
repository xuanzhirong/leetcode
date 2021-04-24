package com.leetcode.study.week4;

/**
 * 367. 有效的完全平方数
 */
public class IsPerfectSquare {
    private int s;

    // 与 MySqrt中 求x的平方根思路大致一样
    // 先用牛顿迭代法，求出num的平方根 square
    // 再判断 square == (int) square
    public boolean isPerfectSquare(int num) {
        s = num;
        if (num == 0) {
            return true;
        }
        double square = square(num);
        return square == (int) square;
    }

    private double square(double num) {
        double res = (num + s / num) / 2;
        if (res == num) {
            return res;
        }
        return square(res);
    }

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare().isPerfectSquare(10));
    }
}
