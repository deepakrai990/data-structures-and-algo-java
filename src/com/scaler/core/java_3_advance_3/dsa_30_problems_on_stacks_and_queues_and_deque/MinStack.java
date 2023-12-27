package com.scaler.core.java_3_advance_3.dsa_30_problems_on_stacks_and_queues_and_deque;

import java.util.Stack;

/**
 * @author Deepak Kumar Rai
 * @created 04/11/23
 * @project scaler_course_code
 */
public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty())
            minStack.push(x);
        else if (x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        int num = stack.pop();
        if (num == minStack.peek())
            minStack.pop();
    }

    public int top() {
        if (stack.isEmpty())
            return -1;

        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            return -1;

        return minStack.peek();
    }
}
