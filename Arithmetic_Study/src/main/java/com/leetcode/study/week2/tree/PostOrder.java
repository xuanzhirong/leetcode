package com.leetcode.study.week2.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 590. N 叉树的后序遍历
 */
public class PostOrder {
    // 递归
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        doPostOrder(root, res);
        return res;
    }

    private void doPostOrder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                doPostOrder(child, res);
            }
        }
        res.add(root.val);
    }

    // 迭代(与中右左的前序遍历是反序)
    // 例如 中右左的前序遍历的结果是0265143，左右中的后序遍历是3415620
    public List<Integer> postorder2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return res;
    }

    private class Node {
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
