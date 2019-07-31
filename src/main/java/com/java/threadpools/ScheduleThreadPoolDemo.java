package com.java.threadpools;

import java.util.concurrent.*;

/**
 * ScheduleThreadPool:
 * 固定线程数量，与FixedThreadPool不同的是：
 * 它可以执行延时任务，也可以执行带有返回值的任务
 */
public class ScheduleThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        /*带有返回值的任务*/
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("执行有返回值的任务");
                return Thread.currentThread().getName();
            }
        });

        scheduledExecutorService.submit(futureTask);
        // 通过FutureTask对象获取返回值
        Object result = futureTask.get();
        System.out.println(result);

        // 执行延时任务
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行延时任务");
            }
        },5L, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }
}
