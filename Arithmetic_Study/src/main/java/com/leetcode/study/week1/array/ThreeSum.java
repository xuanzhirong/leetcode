package com.leetcode.study.week1.array;

import java.util.*;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 首先对数组进行排序
        List<List<Integer>> res = new ArrayList<>();
        // 排序后固定一个数 nums[i],再使用左右指针j,k指向 nums[i]后面的两端
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) { // 如果 nums[i]> 0，则三数之和必然无法等于 0，结束循环
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { // 该数字重复，会导致结果重复，所以应该跳过
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    // j += 1并跳过所有重复的nums[j]
                    while (j < k && nums[j] == nums[++j]) ;
                } else if (sum > 0) {
                    // k -= 1并跳过所有重复的nums[k]
                    while (j < k && nums[k] == nums[--k]) ;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    // j += 1并跳过所有重复的nums[j]
                    while (j < k && nums[j] == nums[++j]) ;
                    // k -= 1并跳过所有重复的nums[k]
                    while (j < k && nums[k] == nums[--k]) ;
                }
            }
        }
        return res;
    }
}
