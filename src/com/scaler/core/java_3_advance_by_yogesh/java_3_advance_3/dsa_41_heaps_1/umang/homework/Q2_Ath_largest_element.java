package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_41_heaps_1.umang.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.PriorityQueue;

/**
 * @created 29/03/23 6:35 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Ath_largest_element {
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
