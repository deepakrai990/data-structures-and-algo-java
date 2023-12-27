package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.assignment;

/**
 * @created 18/08/22 6:35 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    /**
     * Q5. Check if Array is Sorted
     *
     * Problem Description
     * Given an array A, check if it is sorted in non decreasing order or not.
     *
     *
     *
     * Problem Constraints
     * 1 <= Ai <= 109
     * 1 <= |A| <= 105
     *
     *
     *
     * Input Format
     * The first and only argument contains an integer array A.
     *
     *
     *
     * Output Format
     * Return 1 if array is sorted else return 0.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 2]
     *
     * Input 2:
     *
     *  A = [1, 2, 1]
     *
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     *
     * Output 2:
     *
     *  0
     *
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * We can see that the array elements are in non-decreasing order.
     *
     * Explanation 2:
     *
     * Second element is greater than the third element thus array is not non-decreasing, hence not sorted.
     * **/
    private static int solve(int[] A) {
        for(int i = 1; i < A.length; i++) {
            if(A[i - 1] > A[i]) {
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {

    }
}
