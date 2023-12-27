package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms.assignment;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @created 02/04/23 11:06 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Free_Cars {
    private static int solve(int[] A, int[] B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int time = 0;
        int n = A.length;
        int mod = 1000000007;
        int pair[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i] = new int[]{A[i], B[i]};
        }

        //sorting based on time
        Arrays.sort(pair, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            if (pair[i][0] > time) {
                minHeap.add(pair[i][1]);
                time++;
            } else {
                int top = minHeap.peek();
                if (pair[i][1] > top) {
                    minHeap.poll();
                    minHeap.add(pair[i][1]);
                }
            }
        }

        long profit = 0;
        while (!minHeap.isEmpty()) {
            profit = (profit + minHeap.poll()) % mod;
        }
        return (int) profit % mod;
    }
}
