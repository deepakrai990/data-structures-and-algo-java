package com.scaler.core.java_2_intermediate.dsa_07_arrays_subarrays;

/**
 * @created 22/12/22 11:41 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClasQuestion3 {
    /**
     * Given A[N]. Print all subarray sum starting at index 3.
     * Integer[] A = {3, 8, 4, 7, 9, 4, 3, 2, 10, 6};
     * Integer INDEX = 3;
     * **/
    /* Use Carry Forward Technique **/
    private static void printAllSubArraySumStartingIndexAtIndex3(Integer[] A, Integer N, Integer INDEX) {
        Integer sum = 0;
        for (int i = INDEX; i < N; i++) {
            sum += A[i];
            System.out.println(sum); // After every update find new sum and print it
        }
        /*
          Time Complexity: O(N)
          Space Complexity: O(1)
          **/
    }
    public static void main(String[] args) {
        Integer[] A = {3, 8, 4, 7, 9, 4, 3, 2, 10, 6};
        Integer N = A.length;
        Integer INDEX = 3;
        printAllSubArraySumStartingIndexAtIndex3(A, N, INDEX);
    }
}
