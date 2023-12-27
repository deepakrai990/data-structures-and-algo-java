package com.scaler.core.java_2_intermediate.dsa_07_arrays_subarrays.assignment;

import java.util.Arrays;

/**
 * @created 25/09/22 8:01 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Q4. Subarray in given range
     *
     * Problem Description
     * Given an array A of length N, return the subarray from B to C.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * 1 <= A[i] <= 109
     *
     * 0 <= B <= C < N
     *
     *
     *
     * Input Format
     * The first argument A is an array of integers
     *
     * The remaining argumens B and C are integers.
     *
     *
     *
     * Output Format
     * Return a subarray
     *
     *
     * Example Input
     * Input 1:
     * A = [4, 3, 2, 6]
     * B = 1
     * C = 3
     * Input 2:
     *
     * A = [4, 2, 2]
     * B = 0
     * C = 1
     *
     *
     * Example Output
     * Output 1:
     * [3, 2, 6]
     * Output 2:
     *
     * [4, 2]
     *
     *
     * Example Explanation
     * Explanation 1:
     * The subarray of A from 1 to 3 is [3, 2, 6].
     * Explanation 2:
     * The subarray of A from 0 to 1 is [4, 2].
     * **/
    private static int[] solve(int[] A, int B, int C) {
        int subArraySize = C - B + 1;
        int[] subArray = new int[subArraySize];
        int count = 0;
        for(int i = B; i <= C; i++) {
            subArray[count] = A[i];
            count++;
        }
        return subArray;
    }
    /**
     * Scaler Solution
     *
     * Hint 1
     * Just return the subarray from B to C.
     *
     * Solution Approach
     * We return the subarray of A from B to C.
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * **/
    private static int[] solve1(int[] A, int B, int C) {
        return Arrays.copyOfRange(A, B, C + 1);
    }
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        int B = 1;
        int C = 3;
        int[] results = solve(A, B, C);
        System.out.println("Results " + Arrays.toString(results));
        results = solve1(A, B, C);
        System.out.println("Results " + Arrays.toString(results));

    }
}
