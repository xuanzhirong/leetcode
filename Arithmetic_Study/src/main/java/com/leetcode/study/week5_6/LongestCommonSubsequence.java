package com.leetcode.study.week5_6;

/**
 * 1143. 最长公共子序列
 */
public class LongestCommonSubsequence {
    // test1、test2可以当做是二位数组行与列
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1]; // 为了避免 dp[i - 1][j - 1]数组越界，i从1开始
        for (int i = 1; i <= m; i++) {
            char a = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char b = text2.charAt(j - 1);
                if (a == b) { // 最后一个字符相同
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "abd"));
    }
}
