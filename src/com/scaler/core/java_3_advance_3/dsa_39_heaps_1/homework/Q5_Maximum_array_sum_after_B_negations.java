package com.scaler.core.java_3_advance_3.dsa_39_heaps_1.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.PriorityQueue;

/**
 * @created 02/04/23 11:29 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Maximum_array_sum_after_B_negations {
    private static int solve(int[] A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            minHeap.add(A[i]);
            ans += A[i];
        }
        while (B != 0) {
            int curr = minHeap.poll();
            curr *= -1;
            ans += 2 * curr;
            minHeap.add(curr);
            B--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]  A = {24, -68, -29, -9, 84};
        int B = 4;
        int result = solve(A, B);
        PrintUtils.print(result);
    }
}
