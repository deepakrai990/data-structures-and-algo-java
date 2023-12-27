package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.homework;

import java.util.Arrays;

/**
 * @created 26/09/22 7:40 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    /**
     * Q3. Add the matrices
     * <p>
     * Problem Description
     * <p>
     * You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * <p>
     * 1 <= A.size(), B.size() <= 1000
     * <p>
     * 1 <= A[i].size(), B[i].size() <= 1000
     * <p>
     * 1 <= A[i][j], B[i][j] <= 1000
     * <p>
     * <p>
     * <p>
     * Input Format
     * <p>
     * First argument is vector of vector of integers representing matrix A.
     * <p>
     * Second argument is vecotor of vector of integers representing matrix B.
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
     * B = [[9, 8, 7],[6, 5, 4],[3, 2, 1]]
     * <p>
     * <p>
     * Example Output
     * <p>
     * Output 1:
     * <p>
     * [[10, 10, 10], [10, 10, 10], [10, 10, 10]]
     * <p>
     * <p>
     * Example Explanation
     * <p>
     * Explanation 1:
     * <p>
     * A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = [[10, 10, 10], [10, 10, 10], [10, 10, 10]].
     **/
    private static int[][] solve(int[][] A, int[][] B) {
        int N = A.length;
        int M = A[0].length;
        int i, j;
        int C[][] = new int[N][M];

        for (i = 0; i < N; i++)
            for (j = 0; j < M; j++)
                C[i][j] = A[i][j] + B[i][j];

        return C;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * Just intialize an ans vector and push sum of elements of both matrices accordingly.
     * <p>
     * Solution Approach
     * Run a outer loop from i = 1  to i = row,
     * Run a inner loop from j = 1  to j = col, and do A[i][j] += B[i][j],
     * return the updated ans matrix.
     **/
    private static int[][] solve1(int[][] A, int[][] B) {
        int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                A[i][j] += B[i][j];
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] results = solve(A, B);
        System.out.println("Result : " + Arrays.deepToString(results));
        results = solve1(A, B);
        System.out.println("Result : " + Arrays.deepToString(results));
    }
}
