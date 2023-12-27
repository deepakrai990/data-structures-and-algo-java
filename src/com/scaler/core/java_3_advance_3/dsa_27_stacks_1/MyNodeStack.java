package com.scaler.core.java_3_advance_3.dsa_27_stacks_1;

import java.util.EmptyStackException;

/**
 * @created 30/09/23 8:35 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class MyNodeStack<T> {
    private Node<T> top;
    private int size;

    public MyNodeStack() {
        top = null;
        size = 0;
    }
    public boolean isEmpty() {
         return top == null;
    }
    public int size() {
        return size;
    }
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }
}
