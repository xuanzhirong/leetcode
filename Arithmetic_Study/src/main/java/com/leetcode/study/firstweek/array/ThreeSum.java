package com.leetcode.study.firstweek.array;

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
    /**
     * 当 sum== 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
     * 当 sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
     * 时间复杂度：O(n^2) n为数组长度
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 首先对数组进行排序
        List<List<Integer>> res = new ArrayList<>();
        // 排序后固定一个数 nums[k],再使用左右指针指向 nums[k]后面的两端
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) { // 如果 nums[k]> 0，则三数之和必然无法等于 0，结束循环
                break;
            }
            if (k > 0 && nums[k] == nums[k + 1]) { // 该数字重复，会导致结果重复，所以应该跳过
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    // i += 1并跳过所有重复的nums[i]
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    // j -= 1并跳过所有重复的nums[j]
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    // i += 1并跳过所有重复的nums[i]
                    while (i < j && nums[i] == nums[++i]) ;
                    // j -= 1并跳过所有重复的nums[j]
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }
}
