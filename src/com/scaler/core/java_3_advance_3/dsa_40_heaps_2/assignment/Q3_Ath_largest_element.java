package com.scaler.core.java_3_advance_3.dsa_40_heaps_2.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.PriorityQueue;

/**
 * @created 02/04/23 11:24 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Ath_largest_element {
    private static int[] solve(int A, int[] B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {

            if (i < A - 1) {
                ans[i] = -1;
                minHeap.add(B[i]);
            } else if (i == A - 1) {
                minHeap.add(B[i]);
                ans[i] = minHeap.peek();
            } else {
                if (minHeap.peek() < B[i]) {
                    minHeap.poll();
                    minHeap.add(B[i]);
                }
                ans[i] = minHeap.peek();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 4;
        int[] B = {1, 2, 3, 4, 5, 6};
        int[] results = solve(A, B);
        PrintUtils.print(results);
    }
}
