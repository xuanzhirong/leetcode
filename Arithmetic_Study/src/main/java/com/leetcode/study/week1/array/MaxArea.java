package com.leetcode.study.week1.array;

/**
 * 11. 盛最多水的容器
 */
public class MaxArea {
    /**
     * 设每一状态下水槽面积为 S(i,j),(0<=i<j<n)，由于水槽的实际高度由两板中的短板决定，
     * 则可得面积公式 S(i, j) = min(h[i], h[j]) × (j - i)。
     * 在每一个状态下，无论长板或短板收窄 11 格，都会导致水槽 底边宽度 -1−1：
     * 若向内移动短板，水槽的短板 min(h[i],h[j]) 可能变大，因此水槽面积 S(i,j) 可能增大。
     * 若向内移动长板，水槽的短板 min(h[i],h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
     * 因此，向内收窄短板可以获取面积最大值
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
