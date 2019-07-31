package com.java.structure.stack.impl;

import com.java.structure.stack.IStack;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全
 *
 * @param <T>
 */
public class IStackSyncImpl<T> implements IStack<T> {

    public final static Integer DEFAULT_SIZE = 5;
    private T[] stackData;
    private Integer depth = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public IStackSyncImpl() {
        this(DEFAULT_SIZE);
    }

    public IStackSyncImpl(Integer size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size must be positive");
        }
        stackData = (T[]) new Object[size];
    }

    @Override
    public T push(T t) {
        lock.lock();
        try {
            while (full()) { // 当堆栈full时，停止生产
                System.out.println("stack full...");
                condition.await();
            }
            this.stackData[depth++] = t;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    @Override
    public T pop() {
        lock.lock();
        T t = null;
        try {
            while (empty()) { // 当堆栈为empty, 停止消费
                System.out.println("stack empty...");
                condition.await();
            }
            t = this.stackData[--this.depth];
            this.stackData[this.depth] = null;
            condition.signalAll(); // 唤醒阻塞状态的线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    @Override
    public T peek() {
        if (empty()) {
            throw new RuntimeException("stack is empty");
        }
        return this.stackData[this.depth - 1];
    }

    @Override
    public Boolean empty() {
        return this.stackData.length == 0 || this.depth == 0;
    }

    @Override
    public Boolean full() {
        return this.depth == this.stackData.length - 1;
    }
}
