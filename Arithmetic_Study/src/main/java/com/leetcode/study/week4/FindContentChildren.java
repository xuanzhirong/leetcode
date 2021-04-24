package com.leetcode.study.week4;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class FindContentChildren {
    // 思路，把s中最小的饼干分给g中最小的值，且保证条件s[i] >= g[index]
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (index < g.length && s[i] >= g[index]) {
                count++;
                index++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3, 4};
        int[] s = new int[]{4};
        System.out.println(new FindContentChildren().findContentChildren(g, s));
    }
}
