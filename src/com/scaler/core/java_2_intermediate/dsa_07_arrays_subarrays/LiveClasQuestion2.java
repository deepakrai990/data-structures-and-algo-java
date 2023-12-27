package com.scaler.core.java_2_intermediate.dsa_07_arrays_subarrays;

/**
 * @created 22/12/22 11:05 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClasQuestion2 {
    /**
     * Given A[N]. Print each sub-array sum.
     * A[] = {6, 8, -1, 7}
     * **/
    // Idea 1
    private static void printAllSubArraySum(Integer[] A, Integer N) {
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                /* [i to j] : [s to e ], where s is start and e is end of sub-array **/
                Integer sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += A[k];
                }
                System.out.print("sum : " + sum);
                System.out.println();
            }
        }
        /*
         Time Complexity: O(N^3)
         Space Complexity: O(1)
        **/
    }
    /**
     * Idea 2
     * Range Sum : Prefix Technique
     * For every subarray, get it's sum using prefix technique
     * **/
    private static void printAllSubArraySumIdea2(Integer[] A, Integer N) {
        Integer[] pf = new Integer[N];
        pf[0] = A[0];
        for (int i = 1; i < N; i++) {
            pf[i] = pf[i - 1] + A[i];
        }
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                /* [i to j] : [s to e] **/
                Integer sum = 0;
                if (i == 0) sum = pf[i];
                else sum = pf[j] - pf[i - 1];

                System.out.print("sum : " + sum);
                System.out.println();
            }
        }
        /*
         Time Complexity: O(N^2)
         Space Complexity: O(N)
        **/
    }
    /**
     * Idea 3
     * Use Carry Forward Technique
     * **/
    private static void printAllSubArraySumIdea3(Integer[] A, Integer N) {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                System.out.print(sum);
            }
            System.out.println();
        }
        /*
         Time Complexity: O(N^2)
         Space Complexity: O(1)
        **/
    }
    public static void main(String[] args) {
        Integer[] A = {6, 8, -1, 7};
        Integer N = A.length;
        printAllSubArraySum(A, N);
        System.out.println("-----------------------------");
        printAllSubArraySumIdea2(A, N);
    }
}
