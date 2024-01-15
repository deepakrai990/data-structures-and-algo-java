package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 15/12/22 10:07 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Find_count_of_pairs {
    /**
     * Problem: Given an array of N elements.
     * Find count of pairs (i, j) where i & j are indices such as
     * A[i] + A[j] = K. Where i != j.
     * **/
    private static int countOfPairs(int[] A, int B, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] + A[j] == B)
                    count++;
            }
        }
        return count;
    }
    private static int countOfPairs1(int[] A, int B, int N) {
        int count = 0;
        // Create a lower triangular approach
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] + A[j] == B) {
                    count++;
                }
            }
        }

        System.out.println();
        return count;
    }
    public static void main(String[] args) {
        int[] A = {2, 7, 3, 14, 6, 1, 0, 10, 14}; //{3, 5, 2, 1, -3, 7, 8, 15, 6, 13};
        int N = A.length;
        int K = 10;

        int result = countOfPairs(A, K, N);
        PrintUtils.print(result);

        result = countOfPairs1(A, K, N);
        PrintUtils.print(result);
    }
}
