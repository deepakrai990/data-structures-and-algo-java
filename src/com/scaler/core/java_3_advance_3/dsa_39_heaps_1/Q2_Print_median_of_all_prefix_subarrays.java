package com.scaler.core.java_3_advance_3.dsa_39_heaps_1;

import com.scaler.core.utils.PrintUtils;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 27/11/23
 * @project scaler_course_code
 */
public class Q2_Print_median_of_all_prefix_subarrays {
    /**
     * Given an array, print median of all prefix subarrays.
     * **/
    private static int[] runningMedian(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = A[i];

            // Insert into maxHeap
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            // Calculate and print median
            if (i % 2 == 0) {
                ans[i] = maxHeap.peek();
            } else {
                ans[i] = (maxHeap.peek() + minHeap.peek()) / 2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {2, 4, -3, 12, 6, 24, 20, 10};
        int[] results = runningMedian(A);
        PrintUtils.print(results);
    }
}
