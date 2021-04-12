package com.leetcode.study.week2.tree;

import java.util.*;

/**
 * 589. N 叉树的前序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔。
 * <p>
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 */
public class PreOrder {
    // 递归
    public List<Integer> preOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        doPreOrder(root, res);
        return res;
    }

    private void doPreOrder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        List<Node> childes = node.children;
        if (childes == null || childes.size() == 0) {
            return;
        }
        for (Node child : childes) {
            doPreOrder(child, res);
        }
    }

    // 迭代
    public List<Integer> preOrder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root); // 根节点入栈
        while (!stack.isEmpty()) {
            Node pop = stack.pop(); // 弹出栈顶节点
            res.add(pop.val);
            List<Node> childes = pop.children; // 栈顶节点的子节点
            for (int i = childes.size() - 1; i >= 0; i--) {
                stack.push(childes.get(i)); // 子节点逆序入栈，所以出栈为左子节点到右子节点
            }
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
