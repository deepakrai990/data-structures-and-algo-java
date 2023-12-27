package com.scaler.core.java_2_intermediate.dsa_05_arrays_prefix_sum.homework;

import java.util.Arrays;

/**
 * @created 19/09/22 9:02 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    /**
     * Q4. Sum of even indices
     *
     * Problem Description
     * You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists
     * of two integers B[i][0] and B[i][1].
     * For every query, the task is to calculate the sum of all even indices in the range A[B[i][0]…B[i][1]].
     *
     * Note : Use 0-based indexing
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= Q <= 105
     * 1 <= A[i] <= 100
     * 0 <= B[i][0] <= B[i][1] < N
     *
     *
     * Input Format
     * First argument A is an array of integers.
     * Second argument B is a 2D array of integers.
     *
     *
     * Output Format
     * Return an array of integers.
     *
     *
     * Example Input
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     * B = [   [0,2]
     *         [1,4]   ]
     * Input 2:
     * A = [2, 1, 8, 3, 9]
     * B = [   [0,3]
     *         [2,4]   ]
     *
     *
     * Example Output
     * Output 1:
     * [4, 8]
     * Output 2:
     * [10, 17]
     *
     *
     * Example Explanation
     * For Input 1:
     * The subarray for the first query is [1, 2, 3] whose sum of even indices is 4.
     * The subarray for the second query is [2, 3, 4, 5] whose sum of even indices is 8.
     * For Input 2:
     * The subarray for the first query is [2, 1, 8, 3] whose sum of even indices is 10.
     * The subarray for the second query is [8, 3, 9] whose sum of even indices is 17.
     * **/
    private static int[] solve(int[] A, int[][] B) {
        int rows = B.length;
        int[] resultArr = new int[rows];
        for (int i = 0; i < rows; i++) {
            int L = B[i][0];
            int R = B[i][1];
            int sum = 0;
            for (int j = L; j <= R; j++) {
                if (j % 2 == 0) {
                    sum += A[j];
                }
            }
            resultArr[i] = sum;
        }
        return resultArr;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Hint 1
     * Can we precalculate the sum of numbers with even indices in a range ?
     * We should try to answer each query in O(1) time.
     *
     * Solution Approach
     * Create a prefix array pref[] where pref[i+1] will store the sum of numbers with even indices in the subarray A[0…i].
     * Now, the sum of numbers with even indices in the range [L, R] can be easily calculated in O(1) as pref[R + 1] – pref[L].
     *
     * Time Complexity : O(N + Q)
     * Space Complexity : O(N + Q)
     * **/
    private static int[] solve1(int[] A, int[][] B) {
        int n = A.length;
        int[] pref = new int[n];
        pref[0] = A[0];
        for(int i = 1 ; i < n ; i++){
            if(i % 2 == 0){
                pref[i] = pref[i - 1] + A[i];
            }
            else{
                pref[i] = pref[i - 1];
            }
        }
        int[] ans = new int [B.length];
        for(int i = 0 ; i < B.length ; i++){
            int val = pref[B[i][1]];
            if(B[i][0] > 0){
                val -= pref[B[i][0] - 1];
            }
            ans[i] = val;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {2, 1, 8, 3, 9};
        int[][] B = {{0,3},{2,4}};
        int[] results = solve(A, B);
        System.out.println("Results : " + Arrays.toString(results));
        results = solve1(A, B);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
