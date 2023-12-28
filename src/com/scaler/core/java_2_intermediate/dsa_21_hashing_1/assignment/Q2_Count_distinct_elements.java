package com.scaler.core.java_2_intermediate.dsa_21_hashing_1.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;

/**
 * @created 20/02/23 4:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Count_distinct_elements {
    private static int solve(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            hs.add(A[i]);
        }
        return hs.size();
    }

    public static void main(String[] args) {
        int[] A = {3, 3, 3, 9, 0, 1, 0};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
