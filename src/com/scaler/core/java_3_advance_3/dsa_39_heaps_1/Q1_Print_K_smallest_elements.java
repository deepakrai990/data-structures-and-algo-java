package com.scaler.core.java_3_advance_3.dsa_39_heaps_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Print_K_smallest_elements {
    /**
     * Question: Given N distinct element, print K smallest elements in array.
     * Where K < N.
     * **/
    // Using maxHeap
    private static void printKSmallest(int[] A, int K) {
        if (K <= 0 || K > A.length) {
            System.out.println("Invalid value of K");
            return;
        }
        // Create a max-heap with a custom comparator to reverse the natural ordering
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(K, (a, b) -> Integer.compare(b, a));
        // Add the first K elements to the max-heap
        for (int i = 0; i < K; i++) {
            maxHeap.add(A[i]);
        }
        // Process the remaining elements
        for (int i = K; i < A.length; i++) {
            // If the current element is smaller than the largest element in the heap,
            // remove the largest element and add the current element to the heap
            if (A[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(A[i]);
            }
        }
        List<Integer> results = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            results.add(maxHeap.poll());
        }
        // Print the K smallest elements
        System.out.println("K smallest elements using max-heap:");
        Collections.reverse(results);
        for (Integer result: results) {
            System.out.print(result + " ");
        }
    }
    public static void main(String[] args) {
        int[] A = {8, 3, 10, 4, 11, 2, 7, 14, 12, -3};
        int K = 4;
        printKSmallest(A, K);
    }
}
