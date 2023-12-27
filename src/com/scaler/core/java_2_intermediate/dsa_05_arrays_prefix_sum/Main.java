package com.scaler.core.java_2_intermediate.dsa_05_arrays_prefix_sum;

import java.util.Arrays;

/**
 * @created 03/09/22 6:49 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main {
    private static int[] solve(int[] A, int[][] B) {
        int N = A.length;
        int[] prefixSum = new int[N];
        prefixSum[0] = 1 - (A[0] % 2);
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + (1 - (A[i] % 2));
        }
        int rows = B.length;
        int[] resultArr = new int[rows];
        for (int i = 0; i < rows; i++) {
            int L = B[i][0];
            int R = B[i][1];

            int sum = 0;
            if(L == 0) {
                sum = prefixSum[R];
            } else {
                sum = prefixSum[R] - prefixSum[L - 1];
            }
            resultArr[i] = sum;
        }
        return resultArr;
    }
    public static void main(String[] args) {
        int[] A = {8, 6, 7, 10, 3, 10, 10, 3};
        int[][] B = {{0, 4}, {4, 7}, {2, 7}, {6, 7}, {6, 7}, {0, 1}, {2, 6}, {4, 6}, {0, 1}, {1, 2}};
        int[] C = solve(A, B);
        System.out.println(Arrays.toString(C));
    }
}
