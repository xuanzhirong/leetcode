package com.leetcode.study.week3;

import java.security.Key;
import java.util.Arrays;
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
    /**
     * 方法一：摩尔投票法
     * 假设数组中每个不同的数字就代表一个国家，而数字的个数就代表这个国家的人数，他们在一起混战，
     * 就是每两个两个同归于尽。我们就可以知道那个人数大于数组长度一半的肯定会获胜。
     * <p>
     * 就算退一万步来说，其他的所有人都来攻击这个人数最多的国家，他们每两个两个同归于尽，最终剩下的也是那个众数。
     * <p>
     * 时间复杂度 O(n),空间复杂度O(1)
     */
    public int majorityElement(int[] nums) {
        int major = nums[0]; // 选择加入num[0]阵营
        int count = 1; // 当前阵营友军人数
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) { // 前面的都消完了，再重新选择阵营
                count++;
                major = nums[i];
            } else if (major == nums[i]) { // 友军
                count++;
            } else { // 敌人
                count--;
            }
        }
        return major;
    }

    public int majorityElement2(int[] nums) {
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

    // 方法二：排序
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
