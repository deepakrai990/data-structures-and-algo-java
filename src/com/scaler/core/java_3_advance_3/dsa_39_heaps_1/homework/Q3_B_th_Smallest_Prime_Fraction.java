package com.scaler.core.java_3_advance_3.dsa_39_heaps_1.homework;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @created 02/04/23 11:29 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_B_th_Smallest_Prime_Fraction {
    public int[] solve(int[] A, int B) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingDouble(a -> (double) a[0] / (double) a[1]));

        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] fraction = new int[]{A[i], A[j]};
                minHeap.add(fraction);
            }
        }

        int[] ans = new int[2];
        for (int i = 0; i < B; i++)
            ans = minHeap.poll();
        return ans;
    }
}
