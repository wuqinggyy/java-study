package com.gyy.demo.service.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于LinkedHashMap实现lru算法
 */
public class Lru extends LinkedHashMap {

    private int capacity;

    public Lru(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > capacity;
    }


    public static void main(String[] args) {
        Lru lru = new Lru(5);
        lru.put(1, "gyy");
        lru.put(2, "gyy");
        lru.put(3, "gyy");
        lru.put(4, "gyy");
        lru.put(5, "gyy");
        lru.put(16, "gyy");
        lru.put(17, "gyy");
        lru.put(18, "gyy");

        System.out.println(lru);


    }

}

