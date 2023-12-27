package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_41_heaps_1.umang.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.PriorityQueue;

/**
 * @created 29/03/23 6:34 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Connect_ropes {
    private static int solve(int A[]) {
        int ans = 0;
        int l = A.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < l; i++) {
            minHeap.offer(A[i]);
        }
        while (minHeap.size() > 1) {
            int x = minHeap.poll();
            int y = minHeap.poll();
            ans += x + y;
            minHeap.offer(x + y);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int result = solve(A);
        PrintUtils.print(result);
    }
}
