package com.leetcode.study.week1.linklist;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {
    // 递归方式 时间复杂度O(n),空间复杂度O(n)
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 迭代方式 时间复杂度O(n),空间复杂度O(1)
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0); // 哨兵
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            // 交换
            // 交换之前的节点关系是 temp -> node1 -> node2，
            // 交换之后的节点关系要变成 temp -> node2 -> node1
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // 移位
            temp = node1;
        }
        return dummyHead.next;
    }
}
