package com.java.structure.queue;

import com.java.structure.queue.impl.IOneWayQueueImpl;

/**
 * 单向队列测试
 */
public class IOneWayQueueImplTest {
    public static void main(String[] args) {
        IOneWayQueue<String> iOneWayQueue = new IOneWayQueueImpl<>();
        System.out.println("empty(): " + iOneWayQueue.isEmpty());
        System.out.println("full(): " + iOneWayQueue.isFull());
        for (int i = 0; i < 16; i++) {
            iOneWayQueue.addQueue("hello" + i);
        }
        System.out.println(iOneWayQueue.getItem());
        for (int i = 0; i < 6; i++) {
            System.out.println(iOneWayQueue.getQueue());
        }
        System.out.println(iOneWayQueue.getItem());
        for (int i = 0; i < 6; i++) {
            iOneWayQueue.addQueue("word" + i);
        }
        System.out.println(iOneWayQueue);
    }
}
