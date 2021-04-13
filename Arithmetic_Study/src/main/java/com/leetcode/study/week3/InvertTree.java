package com.leetcode.study.week3;

/**
 * 226. 翻转二叉树
 */
public class InvertTree {
    // 记住了递归模板后，分析得到大问题分解为子问题，递归方法自己做了出来
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
