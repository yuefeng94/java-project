package com.java.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CacheThreadPool:
 * 适合处理执行时间比较小的任务
 * 线程空闲时间超过60s就会被杀死，所以长时间处于空闲状态的时候，这种线程池几乎不占用资源
 * 阻塞队列没有存储空间，只要请求到来，就必须找到一条空闲线程去处理这个请求，找不到则在线程池新开辟一条线程
 * 如果主线程提交任务的速度远远大于CachedThreadPool的处理速度，
 * 则CachedThreadPool会不断地创建新线程来执行任务，这样有可能会导致系统耗尽CPU和内存资源，
 * 所以在使用该线程池是，一定要注意控制并发的任务数，否则创建大量的线程可能导致严重的性能问题
 */
public class CacheThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        // executorService.shutdown();
    }
}
