package com.scaler.core.java_3_advance_3.dsa_39_heaps_1.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @created 02/04/23 11:29 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Kth_Smallest_Element_in_a_Sorted_Matrix {
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
