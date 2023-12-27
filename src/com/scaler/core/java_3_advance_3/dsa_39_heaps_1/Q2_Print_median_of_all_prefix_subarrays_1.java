package com.scaler.core.java_3_advance_3.dsa_39_heaps_1;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 27/11/23
 * @project scaler_course_code
 */
public class Q2_Print_median_of_all_prefix_subarrays_1 {
    private static int[] solve(int[] A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = A.length;
        int[] median = new int[n];

        for (int i = 0; i < n; i++) {
            maxHeap.add(A[i]);
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }
            if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size())
                    maxHeap.add(minHeap.poll());
                else
                    minHeap.add(maxHeap.poll());
            }

            int len = minHeap.size() + maxHeap.size();
            if (len % 2 == 0) {
                median[i] = maxHeap.peek();
            } else {
                if (maxHeap.size() > minHeap.size())
                    median[i] = maxHeap.peek();
                else
                    median[i] = minHeap.peek();
            }
        }
        return median;
    }

    private static int[] solve_1(int[] A) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); //maxHeap
        PriorityQueue<Integer> right = new PriorityQueue<>(); //minHeap

        int n = A.length;
        int[] median = new int[n];

        for (int i = 0; i < n; i++) {
            if(left.size() == right.size()) {
                right.add(A[i]);
                left.add(right.poll());
                median[i] = left.peek();
            } else {
                left.add(A[i]);
                right.add(left.poll());
                median[i] = left.peek();
            }
        }
        return median;
    }
}
