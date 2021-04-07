package com.leetcode.study.secondweek.deque.circulardeque;

/**
 * 641. 设计循环双端队列
 * <p>
 * 设计实现双端队列。你的实现需要支持以下操作：
 * <p>
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了
 */
public class LinkedCircularDeque implements CircularDeque {
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public LinkedCircularDeque(int k) {
        this.size = 0;
        this.capacity = k;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        // head -> A -> B -> C -> tail; node 主动与head、A建立关联
        node.prev = head;
        node.next = head.next;
        // head、A与node建立关联
        node.prev.next = node;
        node.next.prev = node;
        size++;
        return true;
    }

    @Override
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        // head -> A -> B -> C -> tail; node 主动与tail、C建立关联
        node.prev = tail.prev;
        node.next = tail;
        // tail、C与node建立关联
        node.prev.next = node;
        node.next.prev = node;
        size++;
        return true;
    }

    @Override
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        // head -> A -> B -> C -> tail; 断开head与A的连接
        Node node = head.next;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node = null;
        size--;
        return true;
    }

    @Override
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        // head -> A -> B -> C -> tail; 断开C与tail的连接
        Node node = tail.prev;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
        size--;
        return true;
    }

    @Override
    public int getFront() {
        return head.next.val;
    }

    @Override
    public int getRear() {
        return tail.prev.val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    public static class Node {
        private int val;
        private Node prev;
        private Node next;

        public Node() {
            this(-1);
        }

        public Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}
