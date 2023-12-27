package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_41_heaps_1.umang.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.PriorityQueue;

/**
 * @created 29/03/23 6:38 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q8_Misha_and_Candies {
    private static int solve(int[] A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : A)
            minHeap.add(num);
        int count = 0;
        while (!minHeap.isEmpty() && minHeap.peek() <= B) {
            int firstMin = minHeap.poll();
            int half = firstMin / 2;
            count += half;
            if (!minHeap.isEmpty()) {
                int secondMin = minHeap.poll();
                secondMin += firstMin - half;
                minHeap.add(secondMin);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 3};
        int B = 4;
        int result = solve(A, B);
        PrintUtils.print(result);
    }
}
