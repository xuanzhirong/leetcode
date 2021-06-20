package com.leetcode.study.week7;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
