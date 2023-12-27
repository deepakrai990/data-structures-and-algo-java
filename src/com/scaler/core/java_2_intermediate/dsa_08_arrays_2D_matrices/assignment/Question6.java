package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.assignment;

import java.util.Arrays;

/**
 * @created 26/09/22 7:14 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question6 {
    /**
     * Q6. Matrix Transpose
     * <p>
     * Problem Description
     * <p>
     * You are given a matrix A, you have to return another matrix which is the transpose of A.
     * <p>
     * NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * <p>
     * 1 <= A.size() <= 1000
     * <p>
     * 1 <= A[i].size() <= 1000
     * <p>
     * 1 <= A[i][j] <= 1000
     * <p>
     * <p>
     * <p>
     * Input Format
     * <p>
     * First argument is vector of vector of integers A representing matrix.
     * <p>
     * <p>
     * <p>
     * Output Format
     * <p>
     * You have to return a vector of vector of integers after doing required operations.
     * <p>
     * <p>
     * <p>
     * Example Input
     * <p>
     * Input 1:
     * <p>
     * A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
     * Input 2:
     * <p>
     * A = [[1, 2],[1, 2],[1, 2]]
     * <p>
     * <p>
     * Example Output
     * <p>
     * Output 1:
     * <p>
     * [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
     * Output 2:
     * <p>
     * [[1, 1, 1], [2, 2, 2]]
     * <p>
     * <p>
     * Example Explanation
     * <p>
     * Explanation 1:
     * <p>
     * Cearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
     * we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].
     **/
    private static int[][] solve(int[][] A) {
        int[][] arr = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    arr[i][j] = A[i][j];
                } else if (i < j) {
                    arr[i][j] = A[j][i];
                } else if (j < i) {
                    arr[i][j] = A[j][i];
                }
            }
        }
        return arr;
    }

    /***
     * Scaler Solution
     *
     * Hint 1
     * Just intialize an ans vector and push column by column elements into it.
     *
     * Solution Approach
     * Note that the i,j ‘th element in the input array (where i is the row and j is the column) is going
     * to be at j,i in the answer matrix.
     * Create an answer matrix and perform the following operations.
     *
     * Run a outer loop from i = 1  to i = col,
     *     initialize a temp vector,
     *     Run a inner loop from j = 1  to j = row, and Push A[j][i]into temp,
     *     push temp in ans vector,
     * return the updated ans matrix.
     *
     * Time Complexity : O(row*col)
     * Space Complexity : O(row*col) (as we are creating an answer matrix having ‘row’
     * number of columns and ‘col’ number of rows.
     * **/
    private static int[][] solve1(int[][] A) {
        int row = A.length, col = A[0].length;
        int[][] ans = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++)
                ans[i][j] = A[j][i];

        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] results = solve(A);
        System.out.println(Arrays.deepToString(results));
        results = solve1(A);
        System.out.println(Arrays.deepToString(results));
    }
}
