package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_41_heaps_1.umang.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.PriorityQueue;

/**
 * @created 29/03/23 6:36 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Product_of_3 {
    private static int[] solve(int[] A) {
        int[] ans = new int[A.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int val = 1;
        for (int i = 0; i < 3; i++) {
            minHeap.add(A[i]);
            val *= A[i];
            if (i < 2) ans[i] = -1;
            else ans[i] = val;
        }
        for (int i = 3; i < A.length; i++) {
            if (A[i] > minHeap.peek()) {
                val = val / minHeap.poll() * A[i];
                minHeap.add(A[i]);
            }
            ans[i] = val;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]  A = {1, 2, 3, 4, 5};
        int[] results = solve(A);
        PrintUtils.print(results);
    }
}
