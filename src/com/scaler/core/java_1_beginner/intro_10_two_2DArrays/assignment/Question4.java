package com.scaler.core.java_1_beginner.intro_10_two_2DArrays.assignment;

/**
 * @created 18/08/22 6:51 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Q4. Add the matrices
     *
     * Problem Description
     *
     * You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.
     *
     *
     * Problem Constraints
     *
     * 1 <= A.size(), B.size() <= 1000
     *
     * 1 <= A[i].size(), B[i].size() <= 1000
     *
     * 1 <= A[i][j], B[i][j] <= 1000
     *
     *
     *
     * Input Format
     *
     * First argument is vector of vector of integers representing matrix A.
     *
     * Second argument is vecotor of vector of integers representing matrix B.
     *
     *
     *
     * Output Format
     *
     * You have to return a vector of vector of integers after doing required operations.
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
     * B = [[9, 8, 7],[6, 5, 4],[3, 2, 1]]
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * [[10, 10, 10], [10, 10, 10], [10, 10, 10]]
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = [[10, 10, 10], [10, 10, 10], [10, 10, 10]].
     * **/
    private static int[][] solve(int[][] A, int[][] B) {
        int totalRow = A.length;
        int totalCol = A[0].length;

        int[][] res = new int[totalRow][totalCol];
        for(int r = 0; r < res.length; r++) {
            for(int c = 0 ; c < res[r].length; c++) {
                res[r][c] = A[r][c] + B[r][c];
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
