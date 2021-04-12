package com.leetcode.study.week1.linklist.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 力扣p146 LRU缓存淘汰算法
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    // 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.removeEldestEntry(eldest);
    }
}
