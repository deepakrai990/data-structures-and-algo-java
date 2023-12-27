package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.homework;

import java.util.Arrays;

/**
 * @created 26/09/22 7:44 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    /**
     * Q4. Matrix Subtraction
     * <p>
     * Problem Description
     * <p>
     * You are given two integer matrices A and B having same size(Both having same number of rows (N)
     * and columns (M)). You have to subtract matrix A from B and return
     * the resultant matrix. (i.e. return the matrix A - B).
     * <p>
     * If X and Y are two matrices of the same order (same dimensions). Then X - Y is a matrix of the
     * same order as X and Y and its elements are obtained by subtracting the elements of Y from the
     * corresponding elements of X. Thus if Z = [z[i][j]] = X - Y, then [z[i][j]] = [x[i][j]] – [y[i][j]].
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * <p>
     * 1 <= N, M <= 103
     * <p>
     * -109 <= A[i][j], B[i][j] <= 109
     * <p>
     * <p>
     * <p>
     * Input Format
     * <p>
     * First argument is a 2D integer matrix A.
     * <p>
     * Second argument is a 2D integer matrix B.
     * <p>
     * <p>
     * <p>
     * Output Format
     * <p>
     * Return a 2D matrix denoting A - B.
     * <p>
     * <p>
     * <p>
     * Example Input
     * <p>
     * Input 1:
     * <p>
     * A = [[1, 2, 3],            B = [[9, 8, 7],
     * [4, 5, 6],                 [6, 5, 4],
     * [7, 8, 9]]                 [3, 2, 1]]
     * Input 2:
     * <p>
     * A = [[1, 1]]               B = [[2, 3]]
     * <p>
     * <p>
     * Example Output
     * <p>
     * Output 1:
     * <p>
     * [[-8, -6, -4],
     * [-2, 0, 2],
     * [4, 6, 8]]
     * Output 2:
     * <p>
     * [[-1, -2]]
     * <p>
     * <p>
     * Example Explanation
     * <p>
     * Explanation 1:
     * <p>
     * image
     * Explanation 2:
     * <p>
     * [[1, 1]] - [[2, 3]] = [[1 - 2, 1 - 3]] = [[-1, -2]]
     **/
    private static int[][] solve(int[][] A, int[][] B) {
        int N = A.length;
        int M = A[0].length;
        int i, j;
        int C[][] = new int[N][M];

        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * This is a simple implementation problem requiring knowledge of loops and 2D arrays.
     * <p>
     * Solution Approach
     * Below mentioned steps explains how we can find difference of two matrices:
     * => To subtract two matrices we have to subtract their corresponding elements.
     * For example, C[i][j] = A[i][j] - B[i][j].
     * => Traverse both matrices row wise(first all elements of a row, then jump to next row) using two loops.
     * => For every element A[i][j], subtract it with corresponding element B[i][j] and store
     * the result in difference matrix at C[i][j].
     **/
    private static int[][] solve1(int[][] A, int[][] B) {
        int N = A.length;
        int M = A[0].length;

        int[][] C = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }

        return C;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] results = solve(A, B);
        System.out.println("Results : " + Arrays.deepToString(results));
        int[][] A1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B1 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        results = solve1(A1, B1);
        System.out.println("Results : " + Arrays.deepToString(results));
    }
}
