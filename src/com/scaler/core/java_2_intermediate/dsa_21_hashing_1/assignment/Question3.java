package com.scaler.core.java_2_intermediate.dsa_21_hashing_1.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;

/**
 * @created 20/02/23 4:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static int solve(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int res = -1;

        for (int i = A.length - 1; i >= 0; i--) {
            if (set.add(A[i]) == false)
                res = A[i];
            set.add(A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {10, 5, 3, 4, 3, 5, 6};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
