package com.scaler.core.java_2_intermediate.dsa_05_arrays_prefix_sum.assignment;

import java.util.Arrays;

/**
 * @created 06/09/22 10:41 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question6 {
    /**
     * Q6. Even numbers in a range
     *
     * Problem Description
     * You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists
     * of two integers B[i][0] and B[i][1].
     * For every query, the task is to find the count of even numbers in the range A[B[i][0]…B[i][1]].
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= Q <= 105
     * 1 <= A[i] <= 109
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
     * [1, 2]
     * Output 2:
     * [2, 1]
     *
     *
     * Example Explanation
     * For Input 1:
     * The subarray for the first query is [1, 2, 3] which contains 1 even number.
     * The subarray for the second query is [2, 3, 4, 5] which contains 2 even numbers.
     * For Input 2:
     * The subarray for the first query is [2, 1, 8, 3] which contains 2 even numbers.
     * The subarray for the second query is [8, 3, 9] which contains 1 even number.
     * **/
    private static int[] solve(int[] A, int[][] B) {
        int N = A.length;
        int[] prefixSum = new int[N];
        prefixSum[0] = 1 - (A[0] % 2);
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + (1 - (A[i] % 2));
        }
        int rows = B.length;
        int[] resultArr = new int[rows];
        for (int i = 0; i < rows; i++) {
            int L = B[i][0];
            int R = B[i][1];

            int sum = 1;
            if(L == 0) {
                sum = prefixSum[R];
            } else {
                sum = prefixSum[R] - prefixSum[L - 1];
            }
            resultArr[i] = sum;
        }
        return resultArr;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Can we precalculate the number of even numbers in a range ?
     * We should try to answer each query in O(1) time.
     *
     * Create a prefix array pref[] where pref[i+1] will store the count of even numbers in the subarray A[0…i].
     * Now, the count of even numbers in the range [L, R] can be easily calculated in O(1) as pref[R + 1] – pref[L].
     *
     * Time Complexity : O(N + Q)
     * Space Complexity : O(N + Q)
     * **/
    private static int[] solve1(int[] A, int[][] B) {
        int n = A.length;
        int[] pref = new int[n + 1];
        pref[0] = 0;
        for(int i = 0 ; i < n ; i++){
            if(A[i] % 2 == 0){
                pref[i + 1] = pref[i] + 1;
            }
            else{
                pref[i + 1] = pref[i];
            }
        }
        int[] ans = new int [B.length];
        for(int i = 0 ; i < B.length ; i++){
            ans[i] = pref[B[i][1] + 1] - pref[B[i][0]];
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] A = {2, 1, 8, 3, 9};
        //int[][] B = {{0,3}, {2,4}};
        int[] A = {16, 3, 3, 6, 7, 8, 17, 13, 7 };
        int[][] B = {{2, 6}, {4, 7}, {6, 7}};
        int[] results = solve(A, B);
        System.out.println("Results : " + Arrays.toString(results));
        results = solve(A, B);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
