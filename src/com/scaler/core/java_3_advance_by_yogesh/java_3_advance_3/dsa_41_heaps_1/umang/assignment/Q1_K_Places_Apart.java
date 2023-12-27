package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_41_heaps_1.umang.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.PriorityQueue;

/**
 * @created 28/03/23 10:14 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_K_Places_Apart {
    private static int[] solve(int[] A, int B) {
        int n = A.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < B; i++)
            minHeap.add(A[i]);

        for (int i = 0; i < n; i++) {
            if (i + B < n)
                minHeap.add(A[i + B]);
            ans[i] = minHeap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 17, 10, 21, 95};
        int B = 1;
        int[] results = solve(A, B);
        PrintUtils.print(results);
    }
}
