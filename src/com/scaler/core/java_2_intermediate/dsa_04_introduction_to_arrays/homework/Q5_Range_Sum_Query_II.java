package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.homework;

import java.util.Arrays;

/**
 * @created 19/09/22 8:29 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q5_Range_Sum_Query_II {
    /**
     * Q5. Range Sum Query - II
     *
     * Problem Description
     * You are given an integer array A of length N.
     * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
     * For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
     * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
     *
     *
     *
     * Problem Constraints
     * 1 <= N, M <= 103
     * 1 <= A[i] <= 105
     * 1 <= L <= R <= N
     *
     *
     * Input Format
     * The first argument is the integer array A.
     * The second argument is the 2D integer array B.
     *
     *
     * Output Format
     * Return an integer array of length M where ith element is the answer for ith query in B.
     *
     *
     * Example Input
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     * B = [[1, 4], [2, 3]]
     * Input 2:
     *
     * A = [2, 2, 2]
     * B = [[1, 1], [2, 3]]
     *
     *
     * Example Output
     * Output 1:
     * [10, 5]
     * Output 2:
     *
     * [2, 4]
     *
     *
     * Example Explanation
     * Explanation 1:
     * The sum of all elements of A[1 ... 4] = 1 + 2 + 3 + 4 = 10.
     * The sum of all elements of A[2 ... 3] = 2 + 3 = 5.
     * Explanation 2:
     *
     * The sum of all elements of A[1 ... 1] = 2 = 2.
     * The sum of all elements of A[2 ... 3] = 2 + 2 = 4.
     * **/
    private static int[] solve(int[] A, int[][] B) {
        //int N = A.length;
        int rows = B.length;
        //int columns = B[0].length;
        int[] resultArr = new int[rows];
        for (int i = 0; i < rows; i++) {
            int L = B[i][0];
            int R = B[i][1];
            int sum = 0;
            for(int j = L - 1; j < R; j++) {
                sum += A[j];
            }
            resultArr[i] = sum;
        }
        return resultArr;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * For every query we traverse the array from L to R
     * and calculate the sum in every case.
     *
     * Time Complexity : O(N*M)
     * Space complexity : O(M)
     * **/
    private static int[] solve1(int[] A, int[][] B) {
        int[] ans = new int[B.length];
        for(int i = 0 ; i < B.length ; i++){
            int sum = 0;
            for(int j = B[i][0] - 1 ; j < B[i][1] ; j++){
                sum += A[j];
            }
            ans[i] = sum;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {{1, 4}, {2, 3}};
        int[] results = solve(A, B);
        System.out.println("Results : " + Arrays.toString(results));
        results = solve1(A, B);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
