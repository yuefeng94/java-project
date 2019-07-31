package com.java.structure.stack;

import com.java.structure.stack.impl.IStackSyncImpl;

public class IStackSyncImplTest {

    public static void main(String[] args) {
        IStackSyncImpl stack = new IStackSyncImpl();
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("push " + stack.push(i));
                }
            }
        };

        Thread producer2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("push " + stack.push(i));
                }
            }
        };

        Thread consumer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("pop " + stack.pop());
                }
            }
        };

        Thread consumer2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("pop " + stack.pop());
                }
            }
        };

        producer.start();
        consumer.start();
        producer2.start();
        consumer2.start();
    }
}
