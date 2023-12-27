package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @created 02/04/23 11:08 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_The_ship_company {
    private static int[] solve(int A, int B, int[] C) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < B; i++) {
            minHeap.add(C[i]);
            maxHeap.add(C[i]);
        }

        int max = 0;
        int min = 0;

        for (int i = 0; i < A; i++) {
            int minVal = 0, maxVal = 0;
            if (!minHeap.isEmpty())
                minVal = minHeap.poll();
            if (!maxHeap.isEmpty())
                maxVal = maxHeap.poll();

            if (minVal > 0) {
                min += minVal;
                minVal -= 1;
                if (minVal > 0)
                    minHeap.add(minVal);
            }
            if (maxVal > 0) {
                max += maxVal;
                maxVal -= 1;
                if (maxVal > 0)
                    maxHeap.add(maxVal);
            }
        }
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int A = 4;
        int B = 3;
        int[] C = {2, 2, 2};

        int[] results = solve(A, B, C);
        PrintUtils.print(results);
    }
}
