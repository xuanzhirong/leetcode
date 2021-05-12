package com.leetcode.study.week5_6;

/**
 * 213. 打家劫舍 II
 */
public class Rob2 {
    //  Math.max(偷第一间,不偷第一间); 转化为求打家劫舍I问题
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // Math.max(偷第一间,不偷第一间)
        return Math.max(doRob(nums, 0, nums.length - 2), doRob(nums, 1, nums.length - 1));
    }

    private int doRob(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
