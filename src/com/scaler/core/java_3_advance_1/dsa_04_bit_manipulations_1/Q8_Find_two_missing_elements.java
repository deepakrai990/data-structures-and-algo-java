package com.scaler.core.java_3_advance_1.dsa_04_bit_manipulations_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 14/01/24
 * @project scaler_course_code
 */
public class Q8_Find_two_missing_elements {
    /**
     * Problem: Given am array A[N]. Array contains all elements from [1 t0 N + 2]/ except two element.
     * Find two missing elements
     * **/
    private static int[] findTwoMissingElements(int[] A) {
        int N = A.length;
        int x = 0, b = 0;
        // Step 1:
        // Take XOR of all array elements
        for (int i = 0; i < N; i++) {
            x = x ^ A[i];
        }
        // Take XOR of all numbers from 1 to N + 2;
        for (int i = 1; i <= N + 2; i++) {
            b = b ^ i;
        }
        int value = x ^ b;
        // Step 2: Find any set position in value
        int position = Integer.MIN_VALUE;
        for (int i = 0; i <= 30; i++) {
            if (checkBit(value, i)) {
                position = i;
                break;
            }
        }
        // Step 3: Split the array-based position into set & unset bit positions
        int set = 0, unset = 0;
        for (int i = 0; i < N; i++) {
            if (checkBit(A[i], position)) {
                set = set ^ A[i];
            } else {
                unset = unset ^ A[i];
            }
        }
        for (int i = 1; i <= N + 2; i++) {
            if (checkBit(i, position)) {
                set = set ^ i;
            } else {
                unset = unset ^ i;
            }
        }
        return new int[] {set, unset};
    }
    private static boolean checkBit(int N, int I) {
        return (N | (1 << I)) == N;
    }
    public static void main(String[] args) {
        int[] A = {1, 6, 4, 7, 5};

        int[] results = findTwoMissingElements(A);
        PrintUtils.print(results);
    }
}
