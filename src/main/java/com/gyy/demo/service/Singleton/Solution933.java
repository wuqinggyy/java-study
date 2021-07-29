package com.gyy.demo.service.Singleton;

import java.util.LinkedList;
import java.util.Queue;

public class Solution933 {

    Queue<Integer> queue;

    public Solution933() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
