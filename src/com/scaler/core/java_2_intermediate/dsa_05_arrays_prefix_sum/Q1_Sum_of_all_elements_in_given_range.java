package com.scaler.core.java_2_intermediate.dsa_05_arrays_prefix_sum;

import java.util.Scanner;

/**
 * @created 15/09/22 8:11 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Sum_of_all_elements_in_given_range {
    /**
     * Given an array of N elements, and Q queries on the same array.
     * For each Query, Calculate the sum of all elements in given range [L - R].
     * L(Left) and R(Right) are indices
     * <p>
     * Inputs : Answer
     * [L  R] :
     * [4  8] :  9
     * [3 7]  : 10
     * [1 3]  : 12
     * [0  4] : 14
     * [6  9] :  3
     * [7  7] : -9
     **/
    /**
     * Brute Force Approach
     * **/
    private static void solveApproach1(int a[], int size, int q) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < q; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            int sum = 0;
            for (int j = left; j <= right; j++) {
                sum += a[j];
            }
            System.out.println("[" + left + "  " + right + "]  : " + sum);
        }
        /**
         * T.C = O(q * n)
         * S.C = O(1)
         * **/
    }
    /**
     * Optimise Approach
     * **/
    private static void solveApproach2(int a[], int size, int q) {
        Scanner in = new Scanner(System.in);
        // Construct PrefixSum Array
        int[] prefixSum = new int[size];
        prefixSum[0] = a[0];
        for (int i = 1; i < size; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        for (int i = 0; i < q; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            int sum = 0;
            if (left == 0) {
                sum = prefixSum[right];
            } else {
                sum = prefixSum[right] - prefixSum[left - 1];
            }
            System.out.println("[" + left + "  " + right + "]  : " + sum);
        }
        /**
         * T.C = O(N + Q)
         * S.C = O(N)
         * **/
    }
    private static int[] createPrefixSum(int[] A, int N) {
        int[] prefixSumArray = new int[N];
        prefixSumArray[0] = A[0];
        for(int i = 1; i < N; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + A[i];
        }
        return prefixSumArray;
    }

    public static void main(String[] args) {
        //          0  1  2  3  4  5  6   7  8  9
        int[] A = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1}; // an array of N elements
        int Q = 6; // queries
        //solveApproach1(A, A.length, Q);
        solveApproach2(A, A.length, Q);
    }
}
