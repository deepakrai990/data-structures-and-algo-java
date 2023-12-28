package com.scaler.core.java_2_intermediate.dsa_05_arrays_prefix_sum.assignment;

import java.util.Arrays;

/**
 * @created 19/09/22 8:47 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q4_In_place_Prefix_Sum {
    /**
     * Q4. In-place Prefix Sum
     * <p>
     * Problem Description
     * Given an array A of N integers. Construct prefix sum of the array in the given array itself.
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <= 103
     * <p>
     * <p>
     * Input Format
     * Only argument A is an array of integers.
     * <p>
     * <p>
     * Output Format
     * Return an array of integers denoting the prefix sum of the given array.
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [1, 2, 3, 4, 5]
     * Input 2:
     * <p>
     * A = [4, 3, 2]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * [1, 3, 6, 10, 15]
     * Output 2:
     * <p>
     * [4, 7, 9]
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * The prefix sum array of [1, 2, 3, 4, 5] is [1, 3, 6, 10, 15].
     * Explanation 2:
     * <p>
     * The prefix sum array of [4, 3, 2] is [4, 7, 9].
     **/
    private static int[] solve(int[] A) {
        int N = A.length;
        for (int i = 1; i < N; i++) {
            A[i] = A[i - 1] + A[i];
        }
        return A;
    }

    /**
     * Scaler Solution
     * Approach
     * <p>
     * We will traverse from left to right of the array.
     * For the leftmost element, we leave it as it as, and
     * for the other elements we add to the element on the
     * left to it. This will form the prefix sum array
     * <p>
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     **/
    private static int[] solve1(int[] A) {
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] results = solve(A);
        System.out.println("Results : " + Arrays.toString(results));
        results = solve1(A);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
