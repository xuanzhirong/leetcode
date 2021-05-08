package com.leetcode.study.dailypractice;

/**
 * 74. 搜索二维矩阵
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (ints[ints.length - 1] >= target) {
                return binarySearch(ints, target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] ints, int target) {
        int left = 0;
        int right = ints.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ints[mid] == target) {
                return true;
            } else if (ints[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
