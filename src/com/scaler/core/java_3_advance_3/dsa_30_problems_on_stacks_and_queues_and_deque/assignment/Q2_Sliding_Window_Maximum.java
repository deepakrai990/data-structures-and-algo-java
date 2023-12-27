package com.scaler.core.java_3_advance_3.dsa_30_problems_on_stacks_and_queues_and_deque.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @created 02/04/23 6:21 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Sliding_Window_Maximum {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int[] slidingMaximum(final int[] A, int B) {
        int[] opt = new int[A.length - B + 1];
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.add(A[0]);
        //prepare the window and the deque first.
        for (int i = 1; i < B; i++) {
            while (!deque.isEmpty() && deque.peekLast() < A[i]) {
                deque.removeLast();
            }
            deque.addLast(A[i]);
        }
        opt[0] = deque.peek();
        //Then start sliding
        for (int i = 1; i <= A.length - B; i++) {
            if (deque.peek() == A[i - 1]) {
                deque.remove();
            }
            //i-1 is removed, i+k-1 is added in window
            while (!deque.isEmpty() && deque.peekLast() < A[i + B - 1]) {
                deque.removeLast();
            }
            deque.addLast(A[i + B - 1]);
            opt[i] = deque.peek();
        }
        return opt;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
        int B = 3;
        int[] results = slidingMaximum(A, B);
        PrintUtils.print(results);
    }
}
