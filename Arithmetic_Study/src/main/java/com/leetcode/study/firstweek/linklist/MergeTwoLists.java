package com.leetcode.study.firstweek.linklist;

/**
 * 21. 合并两个有序链表
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4] 即 l1= 1 -> 2 -> 4, l2 = 1 -> 3 -> 4
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoLists {
    // 迭代（主要思路是获取尾结点和哨兵）
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1); // 哨兵
        ListNode tail = result; // 尾结点
        while (l1 != null && l2 != null) {
            // 选取较小的作为需要插入的尾结点
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next; // 更新尾结点
        }
        //  // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        tail.next = l1 == null ? l2 : l1;
        return result.next;
    }

    /**
     * 递归:
     * 我们判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。（调用递归）
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
