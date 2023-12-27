package com.scaler.core.java_3_advance_3.dsa_29_queues;

import com.scaler.core.utils.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Reverse_first_K_elements_from_front {
    /**
     * Given a Queue, reverse first K elements from front using one stack in same queue.
     * **/
    private static void reverseFirstKElements(Queue<Integer> queue, int K) throws IllegalAccessException {
        if (K <= 0 || K > queue.size()) {
            throw new IllegalAccessException("Invalid value fof K");
        }
        Stack<Integer> stack = new Stack<>();
        // Dequeue the first K elements from the queue and push them onto the stack
        for (int i = 0; i < K; i++) stack.push(queue.poll());
        // Enqueue the reversed elements back into the queue
        while (!stack.isEmpty()) queue.add(stack.pop());
        // Move the remaining elements to the end of the queue
        for (int i = 0; i < queue.size() - K; i++) {
            queue.add(queue.poll());
        }
    }
    public static void main(String[] args) throws IllegalAccessException {
        Queue<Integer> queue = createQueue(3, 10, 2, 12, 19, 6, 8, 10, 14);
        int K = 4;
        System.out.println(queue);
        reverseFirstKElements(queue, K);
        System.out.println(queue);
    }

    private static Queue<Integer> createQueue (int... nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        return queue;
    }
}
