package com.java.structure.stack.impl;

import com.java.structure.stack.IStack;

/**
 * 线程非安全
 *
 * @param <T>
 */
public class IStackImpl<T> implements IStack<T> {

    public final static Integer DEFAULT_SIZE = 5;
    private T[] stackData;
    private Integer depth = 0;

    public IStackImpl() {
        this(DEFAULT_SIZE);
    }

    public IStackImpl(Integer size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size must be positive");
        }
        stackData = (T[]) new Object[size];
    }

    @Override
    public T push(T t) {
        if (full()) {
            throw new RuntimeException("stack is full");
        }
        this.stackData[depth++] = t;
        return t;
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new RuntimeException("stack is empty");
        }
        T t = this.stackData[--this.depth];
        this.stackData[this.depth] = null;
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
