package com.java.structure.stack;

import com.java.structure.stack.impl.IStackImpl;

public class IStackImplTest {

    public static void main(String[] args) {
        IStackImpl stack = new IStackImpl();
        System.out.println("stack empty : " + stack.empty());
        System.out.println("stack push : " + stack.push("hello"));
        System.out.println("stack push : " + stack.push("world"));
        System.out.println("stack push : " + stack.push("java"));
        System.out.println("stack peek : " + stack.peek());
        System.out.println("stack pop : " + stack.pop());
    }
}
