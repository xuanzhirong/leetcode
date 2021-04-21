package com.leetcode.study.week4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * <p>
 * 您需要在二叉树的每一行中找到最大的值。
 */
public class LargestValues {
    // 套用BFS模板
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int levelMax = Integer.MIN_VALUE; // 一层节点的最大值
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode popNode = stack.pop();
                if (levelMax < popNode.val) {
                    levelMax = popNode.val;
                }
                if (popNode.left != null) {
                    stack.add(popNode.left);
                }
                if (popNode.right != null) {
                    stack.add(popNode.right);
                }
            }
            res.add(levelMax);
        }
        return res;
    }
}
