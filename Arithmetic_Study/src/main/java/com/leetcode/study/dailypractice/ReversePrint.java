package com.leetcode.study.dailypractice;

import java.util.List;

/**
 * 06. 从尾到头打印链表
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：输入：head = [1,3,2]输出：[2,3,1]
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        int[] res = new int[n];
        while (head != null) {
            res[--n] = head.val;
            head = head.next;
        }
        return res;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
