package com.scaler.core.java_2_intermediate.dsa_10_arrays_sliding_window.assignment;

/**
 * @created 13/09/22 10:35 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class SubarrayWithGivenSumAndLength {
    private static int solve(int[] A, int B, int C) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            System.out.println("At index("+i+"), sum("+sum+"), B(" + B + ")");
            if (i >= B) {
                System.out.println("A["+i+" - "+B+"] = "+A[i - B]);
                sum -= A[i - B];
            }
            if (sum == C && i >= B - 1) {
                return 1;
            }
        }
        return 0;
    }

    private static int solve1(int[] A, int B, int C) {
        int sum = 0;
        for(int i = 0; i < B; i++) {
            sum += A[i];
        }
        if(sum == C) {
            return 1;
        }
        int startIndex = 1;
        int endIndex = B;
        while(endIndex < A.length) {
            System.out.println("A["+startIndex+" - "+1+"] = "+ A[startIndex - 1]);
            System.out.println("A["+endIndex+"] = " + A[endIndex]);
            sum = sum - A[startIndex - 1] + A[endIndex];
            System.out.println("sum = " + sum);
            if(sum == C) {
                return 1;
            }
            startIndex++;
            endIndex++;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] A1 = { 6, 3, 3, 6, 7, 8, 7, 3, 7 };
        int B1 = 2;
        int C1 = 10;
        int result = solve(A1, B1, C1);
        System.out.println("result : " + result);
        int[] A2 = {8, 7, 7, 6, 6, 3, 1, 5, 7};
        int B2 = 1;
        int C2 = 2;
        result = solve1(A2, B2, C2);
        System.out.println("result : " + result);
    }
}
