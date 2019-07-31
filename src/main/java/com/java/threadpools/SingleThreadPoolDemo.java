package com.java.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadPool:
 * 当线程运行时抛出异常的时候会有新的线程加入线程池替他完成接下来的任务
 * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行，所以这个比较适合那些需要按序执行任务的场景
 * 日志记录一般情况会比较慢（数据量大一般可能不写入数据库），顺序执行会拖慢整个接口，堆积更多请求，还可能会对数据库造成影响（事务在开启中），
 * 所以日志记录完全可以扔到单线程的线程中去，一条条的处理
 */
public class SingleThreadPoolDemo {

    public static void main(String[] args) {
        // 单一线程池,永远会维护存在一条线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            final int j = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " :: " + j);
                }
            });
        }
        executorService.shutdown();
    }
}
