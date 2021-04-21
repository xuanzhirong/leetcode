package com.leetcode.study.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列
 */
public class Permute {
    // 思路: [1,2,3] 可以拆分为 1 + [2,3] , 2 + [1,3] , 3 + [1,2] 的全排序
    // 拆分成n个子全排序，所以每个子全排序都会遍历 int[] nums， 故不能简单的用index作为下一层
    // 可以用 boolean[] visit记录每一次遍历过的int[] nums数据
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        permute(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void permute(int[] nums, boolean[] visit, List<Integer> subList, List<List<Integer>> res) {
        if (subList.size() == nums.length) { // 已经遍历了所有的数据
            res.add(new ArrayList<>(subList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) { // 若已遍历过
                continue;
            }
            visit[i] = true; // 标记为已遍历
            subList.add(nums[i]);
            permute(nums, visit, subList, res);
            visit[i] = false; // 回溯
            subList.remove(subList.size() - 1); // 回溯
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
    }
}
