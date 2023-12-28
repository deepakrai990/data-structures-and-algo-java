package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.homework;

/**
 * @created 19/09/22 5:17 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Max_Min_of_an_Array {
    /**
     * Q1. Max Min of an Array
     *
     * Problem Description
     * Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * -109 <= A[i] <= 109
     *
     *
     * Input Format
     * First argument A is an integer array.
     *
     *
     * Output Format
     * Return the sum of maximum and minimum element of the array
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [-2, 1, -4, 5, 3]
     * Input 2:
     *
     * A = [1, 3, 4, 1]
     *
     *
     * Example Output
     * Output 1:
     *
     * 1
     * Output 2:
     *
     * 5
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1.
     * Explanation 2:
     *
     * Maximum Element is 4 and Minimum element is 1. (4 + 1) = 5.
     * **/
    private static int solve(int[] A) {
        int max = 0;
        int min = 0;
        if(A.length == 1) {
            max = A[0];
            min = A[0];
            return (min + max);
        }
        if (A[0] > A[1]) {
            max = A[0];
            min = A[1];
        } else {
            max = A[1];
            min = A[0];
        }
        for (int i = 2; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            } else if (A[i] < min) {
                min = A[i];
            }
        }
        return (min + max);
    }

    /**
     * Scaler Solution
     * Approach
     *
     * We can loop through the array and find the maximum and minimum
     * element of the array.
     * Finally, we return the sum of the above two elements
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     * **/
    private static int solve1(int[] A) {
        final int inf = (int)(1e9);
        int mn = inf , mx = -inf;
        for(int i = 0 ; i < A.length ; i++){
            mn = Math.min(mn , A[i]);
            mx = Math.max(mx , A[i]);
        }
        return mn + mx;
    }
    public static void main(String[] args) {
        int[] A = {-2, 1, -4, 5, 3};
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
