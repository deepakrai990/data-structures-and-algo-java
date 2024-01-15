package com.scaler.core.java_2_intermediate.dsa_07_arrays_subarrays;

/**
 * @author Deepak Kumar Rai
 * @created 03/01/24
 * @project scaler_course_code
 */
public class Q2_Print_each_and_every_subarray {
    private static void printAllSubarray(int[] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                // [s  e] : [i  j]
                for (int k = i; k <= j; k++) {
                    System.out.print(A[k] + ", ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {

    }
}
