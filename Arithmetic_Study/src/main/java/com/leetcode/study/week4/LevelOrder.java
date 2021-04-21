package com.leetcode.study.week4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    // BFS 直接套用模板即可
    // 变形题，N叉树的层遍历，思路一样，只是子树的记录稍微改一下
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root); // 第一层
        while (!stack.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>(); // 记录一层的节点
            int size = stack.size(); // 一层的节点数
            for (int i = 0; i < size; i++) { // 遍历一层的节点
                TreeNode node = stack.pop();
                levelNodes.add(node.val);
                if (node.left != null) { // 记录下一层的左子节点
                    stack.add(node.left);
                }
                if (node.right != null) { // 记录下一层的右子节点
                    stack.add(node.right);
                }
            }
            res.add(levelNodes);
        }
        return res;
    }
}
