package com.leetcode.study.week8;

/**
 * 191. 位1的个数
 */
public class HammingWeight {
    // 方法一：右移32次
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    // 方法二：消除二进制末尾的 1
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res += 1;
            n &= n - 1;
        }
        return res;
    }
}
