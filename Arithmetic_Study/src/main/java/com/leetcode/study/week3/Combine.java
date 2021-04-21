package com.leetcode.study.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:  输入: n = 4, k = 2   输出:[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
 */
public class Combine {
    // 回溯算法
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n || n < 1) {
            return res;
        }
        combine(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    private void combine(int n, int k, int index, ArrayList<Integer> subList, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(subList));
            return;
        }
        for (int i = index; i <= n - k + 1; i++) { // 需要长度为k，故 i<=n-k+1
            subList.add(i);
            combine(n, k - 1, i + 1, subList, res); // 每取一个数，k-1, index n中的第几个
            subList.remove(subList.size() - 1); // 回溯到上一层
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4,2));
    }
}
