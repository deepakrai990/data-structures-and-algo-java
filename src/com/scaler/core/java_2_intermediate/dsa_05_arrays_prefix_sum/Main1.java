package com.scaler.core.java_2_intermediate.dsa_05_arrays_prefix_sum;

import java.util.Arrays;

/**
 * @created 06/09/22 10:56 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main1 {
    private static int[] solve(int[] prefixSum, int[][] B) {
        int rows = B.length;
        int[] resultArr = new int[rows];
        for (int i = 0; i < rows; i++) {
            int L = B[i][0];
            int R = B[i][1];
            int sum = 0;
            for (int j = L; j <= R; j++) {
                if (j % 2 == 0) {
                    sum += prefixSum[j];
                }
            }
            resultArr[i] = sum;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        //int[] A = {2, 1, 8, 3, 9};
        //int[][] B = {{0,3}, {2,4}};
        int[] A = {16, 3, 3, 6, 7, 8, 17, 13, 7 };
        int[][] B = {{2, 6}, {4, 7}, {6, 7}};
        int[] result = solve(A, B);
        System.out.println(Arrays.toString(result));
    }
}
