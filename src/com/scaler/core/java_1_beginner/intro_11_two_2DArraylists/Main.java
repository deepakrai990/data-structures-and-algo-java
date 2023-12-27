package com.scaler.core.java_1_beginner.intro_11_two_2DArraylists;

import java.util.Arrays;

/**
 * @created 14/08/22 8:12 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main {
    private static int[] solve(int[][] A) {
        int[] result = new int[A.length + A[0].length];
        int resultArrayLength = 0;
        for(int row = 0; row < A.length; row++) {
            int sumOfRows = 0;
            for(int column = 0; column < A[0].length; column++) {
                sumOfRows += A[row][column];
            }
            result[resultArrayLength] = sumOfRows;
            resultArrayLength++;
        }
        for(int column = 0; column < A[0].length; column++) {
            int sumOfRows = 0;
            for(int row = 0; row < A.length; row++) {
                sumOfRows += A[row][column];
            }
            result[resultArrayLength] = sumOfRows;
            resultArrayLength++;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2},{4, 5},{8, 9}};
        solve(A);
    }
}
