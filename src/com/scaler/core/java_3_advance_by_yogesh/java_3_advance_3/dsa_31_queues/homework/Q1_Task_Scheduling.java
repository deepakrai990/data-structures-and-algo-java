package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_31_queues.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 10/03/23 12:25 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Task_Scheduling {
    private static int solve(int[] A, int[] B) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            q.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            while (B[i] != q.peek()) {
                count++;
                int no = q.peek();
                q.remove();
                q.add(no);
            }
            count++;
            q.remove();
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {1, 3, 5, 4, 2};
        int result = solve(A, B);
        PrintUtils.print(result);
    }
}
