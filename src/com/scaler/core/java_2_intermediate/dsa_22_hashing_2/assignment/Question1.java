package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;

/**
 * @created 20/02/23 8:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int solve(int A, int[] B) {
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < B.length; ++i) {
            int temp = A - B[i];
            // checking for condition
            if (s.contains(temp)) {
                return 1;
            }
            s.add(B[i]);
        }
        return 0;
    }

    private static int solve1(int A, int[] B) {
        int size = B.length;
        for (int i = 0; i < (size - 1); i++) {
            for (int j = (i + 1); j < size; j++) {
                if (B[i] + B[j] == A) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int A = 8;
        int[] B = {3, 5, 1, 2, 1, 2};
        int result = solve(A, B);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        result = solve1(A, B);
        PrintUtils.printInt(result);
    }
}
