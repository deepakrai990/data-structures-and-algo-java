package com.scaler.core.java_2_intermediate.dsa_07_arrays_subarrays;

/**
 * @created 25/12/22 6:34 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Find_sum_of_all_subarray_sums {
    /**
     * Google Question
     * Given A[N]. Return sum of all subarray sums.
     * Integer[] A = {6, 8, -1, 7};
     * <p>
     * Using Carry forward technique
     * **/
    private static Integer sumOfAllSubArraySums(Integer[] A, Integer N) {
        Integer totalSum = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                totalSum += sum;
            }
        }
        return totalSum;
        /*
            Time Complexity: O(N^2)
            Space Complexity: O(1)
        **/
    }
    /**
     * Using Contribution Technique
     * **/
    private static Integer sumOfAllSubArraySums2(Integer[] A, Integer N) {
        Integer totalSum;
        totalSum = 0;
        for (int i = 0; i < N; i++) {
            Integer totalNumberOfSubarrayAtIndexI = (i + 1) * (N - i);
            Integer contribution = A[i] * totalNumberOfSubarrayAtIndexI;
            totalSum += contribution;
        }
        /*
            Time Complexity: O(N)
            Space Complexity: O(1)
        **/
        return totalSum;
    }
    public static void main(String[] args) {
        Integer[] A = {6, 8, -1, 7};
        Integer N = A.length;
        Integer result = sumOfAllSubArraySums(A, N);
        System.out.printf("%s%4d \n", "Result: ", result);
        result = sumOfAllSubArraySums2(A, N);
        System.out.printf("%s%4d \n", "Result: ", result);
    }
}
