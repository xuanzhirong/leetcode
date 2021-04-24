package com.leetcode.study.week4;

/**
 * 69. x 的平方根
 */
public class MySqrt {
    int s;

    // 牛顿迭代法
    public int mySqrt(int x) {
        s = x;
        if (x == 0) {
            return 0;
        }
        return (int) sqrt(x);
    }

    private double sqrt(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return res;
        } else {
            return sqrt(res);
        }
    }

    // 二分查找
    public int mySqrt2(int x) {
        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long temp = mid * mid;
            if (temp < x) {
                left = mid + 1;
            } else if (temp == x) {
                return (int) mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(5));
    }
}
