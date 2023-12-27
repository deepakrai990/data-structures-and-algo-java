package com.scaler.core.java_3_advance_3.dsa_30_problems_on_stacks_and_queues_and_deque;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Deepak Kumar Rai
 * @created 03/11/23
 * @project scaler_course_code
 */
public class Q4_Find_max_element_in_every_window {
    /**
     * Given an A[N] & K. Find max element in every window of size K.
     * **/
    private static int[] findMaxElementInEveryWindow(int[] A, int K) {
        List<Integer> results = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        // Step 1: Insert first K elements into the window [0 K - 1]
        for (int i = 0; i < K; i++) {
            // new element = A[i]
            while (!deque.isEmpty() && deque.peekLast() < A[i]) {
                deque.pollLast();
            }
            deque.addLast(A[i]);
        }
        results.add(deque.peekFirst());
        for (int i = K; i < A.length; i++) {
            // new element = A[i]
            // deleted element = A[i - K]
            while (!deque.isEmpty() && deque.peekLast() < A[i]) {
                deque.removeLast();
            }
            deque.addLast(A[i]);
            if (deque.getFirst() == A[i - K]) {
                deque.removeFirst();
            }
            results.add(deque.peekFirst());
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] A = {3, 15, 6, 12, 4, 2, 10, 9, 13, 7, 2, 5, 3};
        int K = 4;
        int[] results = findMaxElementInEveryWindow(A, K);
        PrintUtils.print(results);
    }
}
