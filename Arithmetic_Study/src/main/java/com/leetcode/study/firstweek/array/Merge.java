package com.leetcode.study.firstweek.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
 * 这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 */
public class Merge {
    /**
     * 合并后排序
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 设置指针 index1 和 index2 分别指向 nums1 和 nums2 的有数字尾部，
     * 从尾部值开始比较遍历，同时设置指针 len 指向 nums1 的最末尾，每次遍历比较值大小之后，则进行填充
     * 当其中一个数组遍历结束，若此时 nums2 中还有数据未拷贝完全，将其直接拷贝到 nums1 的前面，最后得到结果数组
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1; // num1的数组末端下标
        int index1 = m - 1; // num1最大数据的数组下标
        int index2 = n - 1; // num2最大数据的数组下标
        while (index1 >= 0 && index2 >= 0) {
            // 比较nums1和num2的最大数据，较大的插入到数组末端nums1[index]
            nums1[index--] = nums2[index2] > nums1[index1] ? nums2[index2--] : nums1[index1--];
        }
        // 若num2中有剩余数据，则把剩余数据直接复制到nums1中；注意 <=index2
        for (int i = 0; i <= index2; i++) {
            nums1[i] = nums2[i];
        }
    }

}
