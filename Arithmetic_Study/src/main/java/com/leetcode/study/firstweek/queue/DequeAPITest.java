package com.leetcode.study.firstweek.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeAPITest {
    public static void main(String[] args) {
        DequeAPITest test = new DequeAPITest();
        test.test();
    }
    public void test() {
        Deque<String> deque = new LinkedList<>();

        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        System.out.println(deque.peek());
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }
}
