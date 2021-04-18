package com.leetcode.study.week3;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素
 * <p>
 * 示例 1：
 * 输入：[3,2,3] 输出：3
 * <p>
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2] 输出：2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Integer count = map.getOrDefault(nums[i], 0) + 1;
            if (count > n / 2) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return -1;
    }
}
