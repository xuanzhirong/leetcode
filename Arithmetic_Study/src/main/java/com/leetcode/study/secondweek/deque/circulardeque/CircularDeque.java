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
public interface CircularDeque {
    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    boolean insertFront(int value);

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    boolean insertLast(int value);

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    boolean deleteFront();

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    boolean deleteLast();

    /**
     * Get the front item from the deque.
     */
    int getFront();

    /**
     * Get the last item from the deque.
     */
    int getRear();

    /**
     * Checks whether the circular deque is empty or not.
     */
    boolean isEmpty();

    /**
     * Checks whether the circular deque is full or not.
     */
    boolean isFull();
}
