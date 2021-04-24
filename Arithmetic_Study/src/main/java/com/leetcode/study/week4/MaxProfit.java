package com.leetcode.study.week4;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class MaxProfit {
    // prices[i] < prices[i + 1]只要有钱挣，就卖出
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
