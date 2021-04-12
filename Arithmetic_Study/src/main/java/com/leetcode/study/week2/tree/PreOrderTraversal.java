package com.leetcode.study.week2.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 示例 1: 输入：root = [1,null,2,3] 输出：[1,2,3]
 * 示例 2：输入：root = [] 输出：[]
 * 示例 3：输入：root = [1] 输出：[1]
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreOrderTraversal {
    // 递归
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doOrderTraversal(root, res);
        return res;
    }

    private void doOrderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        doOrderTraversal(root.left, res);
        doOrderTraversal(root.right, res);
    }

    // 迭代
    public List<Integer> preOrderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
