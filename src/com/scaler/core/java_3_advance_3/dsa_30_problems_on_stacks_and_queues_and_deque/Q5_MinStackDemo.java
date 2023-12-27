package com.scaler.core.java_3_advance_3.dsa_30_problems_on_stacks_and_queues_and_deque;

/**
 * @author Deepak Kumar Rai
 * @created 04/11/23
 * @project scaler_course_code
 */
public class Q5_MinStackDemo {
    /**
     * Design a data structure MinStack which support the following.
     * 1. Push
     * 2. Pop
     * 3. getMin
     * 4. getTop
     * All should take O(1) time.
     * **/
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(3);
        minStack.push(5);
        System.out.println("Top: " + minStack.top()); // Output: 5
        System.out.println("Min: " + minStack.getMin()); // Output: 3

        minStack.push(2);
        System.out.println("Top: " + minStack.top()); // Output: 2
        System.out.println("Min: " + minStack.getMin()); // Output: 2

        minStack.pop();
        System.out.println("Top: " + minStack.top()); // Output: 5
        System.out.println("Min: " + minStack.getMin()); // Output: 3

    }
}
