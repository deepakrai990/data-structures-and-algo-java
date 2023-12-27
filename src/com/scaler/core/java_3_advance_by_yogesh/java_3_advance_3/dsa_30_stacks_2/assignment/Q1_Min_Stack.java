package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_30_stacks_2.assignment;

import java.util.Stack;

/**
 * @created 07/03/23 12:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Min_Stack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0) minStack.push(x);
        else {
            min = Math.min(minStack.peek(), x);
            minStack.push(min);
        }
    }

    public void pop() {
        if (stack.size() == 0 && minStack.size() == 0) return;
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.size() == 0) return -1;
        return stack.peek();
    }

    public int getMin() {
        if (minStack.size() == 0) return -1;
        return minStack.peek();
    }
}
