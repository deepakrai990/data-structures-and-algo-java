package com.scaler.core.java_3_advance_3.dsa_29_queues.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @created 02/04/23 6:29 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Sliding_Window_Maximum {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int[] slidingMaximum(final int[] A, int B) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[A.length - B + 1];
        for (int i = 0; i < A.length; i++) {
            if (!deque.isEmpty() && i - deque.peek() + 1 > B)
                deque.poll();
            while (!deque.isEmpty() && A[deque.peekLast()] <= A[i])
                deque.pollLast();
            deque.add(i);
            if (i >= B - 1)
                ans[i - B + 1] = A[deque.peek()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
        int B = 3;
        int[] results = slidingMaximum(A, B);
        PrintUtils.print(results);
    }
}
