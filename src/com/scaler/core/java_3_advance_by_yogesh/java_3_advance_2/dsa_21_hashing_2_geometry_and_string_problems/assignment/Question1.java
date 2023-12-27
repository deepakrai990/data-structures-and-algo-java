package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_21_hashing_2_geometry_and_string_problems.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @created 18/02/23 7:04 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int solve(int[] A, int[] B) {
        int n = A.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(A[i] + "-" + B[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] < A[j] && B[i] < B[j] &&
                        set.contains(A[i] + "-" + B[j]) &&
                        set.contains(A[j] + "-" + B[i]))
                    ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 3, 3};
        int[] B = {1, 2, 1, 2, 1, 2};
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
