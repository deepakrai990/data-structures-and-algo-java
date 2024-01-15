package com.scaler.core.java_2_intermediate.dsa_21_hashing_1;

import java.util.HashSet;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q7_Exists_a_subarray_with_sum_equals_to_0 {
    /**
     * Problem: Check if there exists a subarray with sum equals to zero
     * Given array A[N]. Check if there exists a subarray with sum equals to zero
     * **/
    private static boolean subArrayWithZero(int[] A) {
        int N = A.length;
        int[] prefixSum = prefixSum(A);
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (prefixSum[i] == 0) {
                return true;
            }
            hs.add(prefixSum[i]);
        }
        if (hs.size() < N) {
            return true;
        } else {
            return false;
        }
    }
    private static int[] prefixSum(int[] A) {
        int N = A.length;
        int[] pfSum = new int[N];
        pfSum[0] = A[0];
        for (int i = 1; i < N; i++) {
            pfSum[i] = pfSum[i - 1] + A[i];
        }
        return pfSum;
    }
    public static void main(String[] args) {
        int[] A = {2, 2, 1, -3, 4, 3, 1, -2, -3, 2};

        boolean result = subArrayWithZero(A);
        System.out.println("Subarray with Zero Sum Exists: " + result);
    }
}
