package com.leetcode.study.week1.linklist.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 146 LRU缓存机制
 */
public class LRUCache2 {
    private int size; // 元素个数
    private int capacity; // 容量
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    // 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    // 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
    // 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.val = value;
            moveToHead(node);
            return;
        }
        // 如果 key 不存在，创建一个新的节点
        DLinkedNode newNode = new DLinkedNode(key, value);
        // 添加进哈希表
        cache.put(key, newNode);
        // 添加至双向链表的头部
        addToHead(newNode);
        ++size;
        if (size > capacity) {
            // 如果超出容量，删除双向链表的尾部节点
            DLinkedNode tail = removeTail();
            // 删除哈希表中对应的项
            cache.remove(tail.key);
            --size;
        }
    }

    private void addToHead(DLinkedNode node) {
        // node 与其他节点连接
        node.prev = head;
        node.next = head.next;
        // 其他节点连接 node
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


    static class DLinkedNode {
        int key, val;
        DLinkedNode next;
        DLinkedNode prev;

        public DLinkedNode() {
        }

        public DLinkedNode(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
}
