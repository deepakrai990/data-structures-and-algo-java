package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.homework;

/**
 * @created 26/09/22 7:36 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    /**
     * Q2. Are Matrices Same ?
     * <p>
     * Problem Description
     * You are given two matrices A & B of equal dimensions and you have to check whether two matrices
     * are equal or not.
     * <p>
     * NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j in the given range.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A.size(), B.size() <= 1000
     * <p>
     * 1 <= A[i].size(), B[i].size() <= 1000
     * <p>
     * 1 <= A[i][j], B[i][j] <= 1000
     * <p>
     * <p>
     * <p>
     * Input Format
     * First argument is vector of vector of integers representing matrix A.
     * <p>
     * Second argument is vector of vector of integers representing matrix B.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return 1 if both matrices are equal or return 0.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
     * B = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
     * Input 2:
     * <p>
     * A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
     * B = [[1, 2, 3],[7, 8, 9],[4, 5, 6]]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 1
     * Output 2:
     * <p>
     * 0
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * ==> Clearly all the elements of both matrices are equal at respective positions.
     * Explanation 2:
     * <p>
     * ==> Clearly all the elements of both matrices are not equal at respective positions.
     **/
    private static int solve(int[][] A, int[][] B) {
        int N = A.length;
        int M = A[0].length;
        int i, j;
        for (i = 0; i < N; i++)
            for (j = 0; j < M; j++)
                if (A[i][j] != B[i][j])
                    return 0;
        return 1;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * Check all the elements of both matrices one by one and return 1 if all are equal otherwise return 0.
     * <p>
     * Solution Approach
     * Here run a outer loop for i = 0 to i = row,
     * and inner loop from j = 0 to j = col,
     * and return 0 if any A[i][j] != B[i][j]
     * otherwise return 1 at the end of the loop.
     **/
    private static int solve1(int[][] A, int[][] B) {
        int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (A[i][j] != B[i][j]) return 0;
        return 1;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int result = solve(A, B);
        System.out.println("Result : " + result);
        result = solve1(A, B);
        System.out.println("Result : " + result);
    }
}
