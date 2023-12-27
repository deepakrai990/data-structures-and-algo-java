package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_41_heaps_1.umang.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @created 29/03/23 6:37 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q7_Kth_Smallest_Element_in_a_Sorted_Matrix {
    private static int solve(int[][] A, int B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                maxHeap.add(A[i][j]);
                if (maxHeap.size() > B) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[][] A = {{9, 11, 15}, {10, 15, 17}};
        int B = 6;
        int result = solve(A, B);
        PrintUtils.print(result);
    }
}
