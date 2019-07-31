package com.java.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 适合用在稳定且固定的并发场景
 * 这种线程池不会拒绝任务，而且不会开辟新的线程，也不会因为线程的长时间不使用而销毁线程
 */
public class FixedThreadPoolDemo {

    public static void main(String[] args) {
        int number = Runtime.getRuntime().availableProcessors();
        System.out.println("计算机cup 核数："  + number);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(number * 1); // 线程数 = 核数 * n
        for (int i = 0; i < 10; i++) {
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        // newFixedThreadPool.shutdown(); // 关闭线程池
    }
}
