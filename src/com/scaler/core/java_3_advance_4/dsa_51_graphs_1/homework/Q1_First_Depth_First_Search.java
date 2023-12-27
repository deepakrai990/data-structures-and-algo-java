package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.homework;

/**
 * @created 02/04/23 8:32 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_First_Depth_First_Search {
    public int solve(int[] A, final int B, final int C) {
        if (B == C) return 1;
        int i = B - 1;
        while (i > 0) {
            if (A[i] == C) return 1; //checking current node
            i = A[i] - 1; //jumping to previous node index
            //repeat
        }
        return 0;
    }
}
