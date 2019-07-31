package com.java.structure.stack;

public interface IStack<T> {

    public T push(T t);

    public T pop();

    public Boolean empty();

    public T peek();
}
