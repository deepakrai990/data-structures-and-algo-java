package com.scaler.core.java_2_intermediate.dsa_07_arrays_subarrays;

/**
 * @created 17/12/22 3:59 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Print_the_subarray_start_to_end {
    /**
     * Given A[N]. Print each & every subarray
     * A[] = {6, 8, -1, 7}
     * **/
    private static void printAllSubArray(int[] A, int N) {
        //From where to start 
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                /* [i to j] : [s to e] **/
                for (int k = i; k <= j; k++) {
                    System.out.print(A[k] + " ");
                }
                System.out.println();
            }
        }
    }
    private static void printAllSubarray(int[] A, int N) {
        for (int start = 0; start < N; start++) {
            for (int end = start; end < N; end++) {
                //System.out.println("Start ["+start+"], end [" + end + "]");
                for (int i = start; i <= end; i++) {
                    System.out.print(A[i] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int[] A = {2, 6, 7, 8, 20};
        int N = A.length;
        printAllSubarray(A, N);
        System.out.println("---------------------------------");
        printAllSubArray(A, N);
    }
}
