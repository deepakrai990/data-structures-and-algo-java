package com.scaler.core.java_3_advance_3.dsa_30_problems_on_stacks_and_queues_and_deque.assignment;

import java.util.Stack;

/**
 * @created 02/04/23 6:27 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Min_Stack {
    private final Stack<Integer> mainStack;
    private final Stack<Integer> minStack;

    public Q3_Min_Stack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        mainStack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            int poppedValue = mainStack.pop();
            if (poppedValue == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int getTop() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        throw new IllegalStateException("Stack is empty.");
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new IllegalStateException("Stack is empty.");
    }

    public static void main(String[] args) {
        Q3_Min_Stack minStack = new Q3_Min_Stack();

        minStack.push(3);
        minStack.push(5);
        System.out.println("Top: " + minStack.getTop()); // Output: 5
        System.out.println("Min: " + minStack.getMin()); // Output: 3

        minStack.push(2);
        System.out.println("Top: " + minStack.getTop()); // Output: 2
        System.out.println("Min: " + minStack.getMin()); // Output: 2

        minStack.pop();
        System.out.println("Top: " + minStack.getTop()); // Output: 5
        System.out.println("Min: " + minStack.getMin()); // Output: 3
    }
}
