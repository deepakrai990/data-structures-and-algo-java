package com.scaler.core.java_2_intermediate.dsa_21_hashing_1;

import java.util.HashMap;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q3_Find_frequency_of_numbers1 {
    /**
     * Problem: Find frequency of numbers
     * Given array A[N] and array Q[N] queries. For every query, find the frequency of element in an array
     * **/
    private static void printFrequency(int[] A, int[] Q) {
        int N = A.length, M = Q.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        for (int i = 0; i < M; i++) {
            if (hm.containsKey(Q[i])) {
                System.out.println("Frequency of " + Q[i] + " : " + hm.get(Q[i]));
            } else {
                System.out.println("Frequency of " + Q[i] + " : " + 0);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] A = {2, 6, 3, 8, 2, 8, 2, 3, 8, 10, 6};
        int[] Q = {2, 8, 3, 5};
        printFrequency(A, Q);
    }
}
