package com.leetcode.study.week5_6;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]  输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // 行数
        int n = grid[0].length; // 列数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) { // 沿着第一行往右
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) { // 沿着第一列往下
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MinPathSum().minPathSum(grid));
    }
}
