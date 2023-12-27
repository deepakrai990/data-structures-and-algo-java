package com.scaler.core.java_3_advance_3.dsa_27_stacks_1;

import java.util.EmptyStackException;

/**
 * @created 30/09/23 8:14 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class MyStack<T> {
    // Last in first out (LIFO)
    private static final Integer INITIAL_CAPACITY = 10;
    private Object[] arr;
    private int size;
    public MyStack() {
        arr = new Object[INITIAL_CAPACITY];
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public Integer size() {
        return size;
    }
    private void resizeArr() {
        int newCapacity = arr.length * 2;
        Object[] newArr = new Object[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }
    public void push(T item) {
        if (size == arr.length) resizeArr();
        arr[size++] = item;
    }
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T item = (T) arr[--size];
        arr[size] = null;
        return item;
    }
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new  EmptyStackException();
        return (T) arr[size - 1];
    }
}
