package com.scaler.core.java_3_advance_1.dsa_06_maths_modular_arithmetic;

import com.scaler.core.utils.PrintUtils;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Calculate_no_of_pairs {
    /**
     * Problem: Given an array A[N], where elements are positive(+ive).
     * Calculate the number of pairs (i, j) such that (A[i] + A[j]) % M = 0.
     * **/
    // Bruteforce Approach
    private static int countPairMod(int[] A, int M) {
        int N = A.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((A[i] + A[j]) % M == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    // Optimise Approach 1 need to work here
    private static int countPairMod1(int[] A, int M) {
        int N = A.length;
        Map<Integer, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        int count = 0;
        int x = hm.get(0);
        count = count + (x * (x - 1)) / 2;
        if (M % 2 == 0) {
            x = hm.get(M / 2);
            count = count + (x * (x - 1)) / 2;
        }
        for (int i = 1; i < (M + 1) / 2; i++) {
            count = count + hm.get(i) * hm.get(M - i);
        }
        return count;
    }
    // Optimise Approach 2 Function to calculate the number of pairs (i, j) such that (A[i] + A[j]) % M = 0
    private static int countPairsWithSumMod(int[] A, int M) {
        int n = A.length;
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        int count = 0;
        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Calculate the remainder when the current element is divided by M
            int remainder = A[i] % M;
            // Check if the complement of the remainder exists in the hashmap
            if (remainderCount.containsKey((M - remainder) % M)) {
                // Add the count of occurrences of the complement to the total count
                count += remainderCount.get((M - remainder) % M);
            }
            // Update the hashmap with the current remainder
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {4, 7, 6, 5, 8, 3};
        int M = 3;

        int result = countPairMod(A, M);
        PrintUtils.print(result);

        result = countPairsWithSumMod(A, M);
        PrintUtils.print(result);
    }
}
