package com.leetcode.study.firstweek.array;

/**
 * 189. 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class Rotate {
    // 临时数组
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        // 把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = temp[i];
        }
    }

    // 多次反转
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        revert(nums, 0, n - 1); // 先全部反转
        revert(nums, 0, k - 1); // 然后反转前k个
        revert(nums, k, n - 1); // 最后反转剩余的
    }

    public void revert(int[] nums, int start, int end) {
        while (start < end) {
            int tem = nums[start];
            nums[start] = nums[end];
            nums[end] = tem;
            start++;
            end--;
        }
    }

    //解法3
    public void rotate3(int[] nums, int k) {
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            index = (index + k) % length;
            if (visited[index]) {
                // 如果访问过，再次访问，会出现原地打转的现象,所以我们直接从他的下一个元素开始
                index = (index + 1) % length;
                hold = nums[index];
                i--;
            } else {
                // 把当前值保存在下一个位置，保存之前把下一个位置的值给记录下来
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }
}
