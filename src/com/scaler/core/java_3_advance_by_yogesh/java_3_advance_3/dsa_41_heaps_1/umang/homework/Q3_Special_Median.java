package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_41_heaps_1.umang.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @created 29/03/23 6:35 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Special_Median {
    private static int solve(int[] A) {
        int n = A.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

        for (int i = 1; i < n; i++) {
            if (maxHeap.size() > 0 && A[i - 1] > maxHeap.peek())
                minHeap.add(A[i - 1]);
            else
                maxHeap.add(A[i - 1]);

            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            else if (minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());

            if (maxHeap.size() == minHeap.size()) {
                int a = maxHeap.peek();
                int b = minHeap.peek();
                float f = (a + b) / 2f;
                if (f == A[i]) return 1;
            } else if (maxHeap.peek() == A[i])
                return 1;
        }

        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Collections.reverseOrder());

        for (int i = n - 2; i >= 0; i--) {
            if (maxHeap.size() > 0 && A[i + 1] > maxHeap.peek())
                minHeap.add(A[i + 1]);
            else
                maxHeap.add(A[i + 1]);

            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            else if (minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());

            if (maxHeap.size() == minHeap.size()) {
                int a = maxHeap.peek();
                int b = minHeap.peek();
                float f = (a + b) / 2f;
                if (f == A[i]) return 1;
            } else if (maxHeap.peek() == A[i])
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {4, 6, 8, 4};
        int result = solve(A);
        PrintUtils.print(result);
    }
}
