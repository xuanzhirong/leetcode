package com.leetcode.study.week3;

/**
 * 236. 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
 */
public class LowestCommonAncestor {
    /**
     * 思路：若p,q在同一侧子树，例如都在左子树，则遍历左子树；若最先遍历到 p(或q)，则 p(或q)为最近公共祖先；
     * 若p,q不在同一侧，根节点为公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // 找到p或q
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) { // 左子树没有找到 p和q，那么就在右子树
            return right;
        }
        if (right == null) { // 右子树没有找到 p和q,那么就在左子树
            return left;
        }
        return root; // p,q分别在左右子树，则根节点为最近公共祖先
    }
}
