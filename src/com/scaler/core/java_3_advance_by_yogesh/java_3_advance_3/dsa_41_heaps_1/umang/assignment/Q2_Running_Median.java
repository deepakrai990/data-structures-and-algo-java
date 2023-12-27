package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_41_heaps_1.umang.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @created 28/03/23 10:14 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Running_Median {
    private static int[] solve(int[] A) {
        // contains all smaller elements than minHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.size();
        int n = A.length;
        int[] median = new int[n];

        for (int i = 0; i < n; i++) {
            maxHeap.add(A[i]);
            //check 1
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }
            //check 2
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

    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        int[] results = solve(A);
        PrintUtils.print(results);
        PrintUtils.printNewLine();
        results = solve_1(A);
        PrintUtils.print(results);
    }
}
