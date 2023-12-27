package com.scaler.contest.tct_2;

import com.scaler.core.utils.PrintUtils;

import java.util.PriorityQueue;

/**
 * @created 26/09/23 4:12 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Winner_Stone {
    private static int solve(int[] A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone: A) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            int diff = y - x;
            if (diff > 0) {
                maxHeap.offer(diff);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int result = solve(A);
        PrintUtils.print(result);
    }
}
