package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.assignment;

/**
 * @created 19/09/22 4:55 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. Count of elements
     * <p>
     * Problem Description
     * Given an array A of N integers. Count the number of elements that have at least 1 elements greater than itself.
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <= 109
     * <p>
     * <p>
     * Input Format
     * First and only argument is an array of integers A.
     * <p>
     * <p>
     * Output Format
     * Return the count of elements.
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * A = [3, 1, 2]
     * Input 2:
     * A = [5, 5, 3]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * 2
     * Output 2:
     * 1
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * The elements that have at least 1 element greater than itself are 1 and 2
     * Explanation 2:
     * The elements that have at least 1 element greater than itself is 3
     **/
    private static int solve(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(A[i], max);
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != max) {
                count++;
            }
        }
        return count;
    }

    /**
     * Scaler Solution
     * Approach
     * We need to count the number of elements in the array
     * that are not equal to the maximum value of the array.
     * We can traverse the array and get this count.
     * <p>
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     **/
    private static int solve1(int[] A) {
        int max_value = 0, max_count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max_value) {
                max_value = A[i];
                max_count = 1;
            } else if (A[i] == max_value) {
                max_count += 1;
            }
        }
        return A.length - max_count;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2};
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
