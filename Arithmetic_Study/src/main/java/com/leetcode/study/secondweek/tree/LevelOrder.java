package com.leetcode.study.secondweek.tree;

import java.util.*;

/**
 * 429. N 叉树的层序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔
 * <p>
 * 示例1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * <p>
 * 示例2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
public class LevelOrder {
    // 利用队列实现广度优先搜索
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 首先将根节点放到队列中
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) { // 当队列不为空时，则在队列取出一个节点，并将其子节点添加到队列中
            List<Integer> levelResult = new ArrayList<>(); // 存储一层的子节点值
            int size = queue.size(); // 每一层的节点数
            for (int i = 0; i < size; i++) { // 遍历一层的节点
                Node node = queue.poll(); // 队列出一个节点
                levelResult.add(node.val);
                queue.addAll(node.children); // 将其子节点添加到队列中
            }
            res.add(levelResult);
        }
        return res;
    }

    // 简化的广度优先
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Node> currentLayer = Arrays.asList(root); // 当前层节点集合
        while (!currentLayer.isEmpty()) {
            List<Node> nextLayer = new ArrayList<>(); // 下一次节点集合
            List<Integer> currentValues = new ArrayList<>(); // 当前层值集合
            for (Node node : currentLayer) { // 遍历当前层节点集合
                currentValues.add(node.val);
                nextLayer.addAll(node.children); // 存储将下一层节点
            }
            res.add(currentValues);
            currentLayer = nextLayer;
        }
        return res;
    }

    // 递归
    public List<List<Integer>> levelOrder3(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            doLevelOrder(root, res, 0);
        }
        return res;
    }

    private void doLevelOrder(Node node, List<List<Integer>> res, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        for (Node child : node.children) {
            doLevelOrder(child, res, level + 1);
        }
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
