package com.scaler.core.java_1_beginner.intro_11_two_2DArraylists.assignment;

/**
 * @created 18/08/22 2:30 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Matrix Multiplication
     *
     * Problem Description
     *
     * You are given two integer matrices A(having M X N size) and B(having N X P). You have to multiply
     * matrix A with B and return the resultant matrix. (i.e. return the matrix AB).
     *
     * image
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= M, N, P <= 100
     *
     * -100 <= A[i][j], B[i][j] <= 100
     *
     *
     *
     * Input Format
     *
     * First argument is a 2D integer matrix A.
     *
     * Second argument is a 2D integer matrix B.
     *
     *
     *
     * Output Format
     *
     * Return a 2D integer matrix denoting AB.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  A = [[1, 2],            B = [[5, 6],
     *       [3, 4]]                 [7, 8]]
     *
     * Input 2:
     *
     *  A = [[1, 1]]            B = [[2],
     *                               [3]]
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  [[19, 22],
     *   [43, 50]]
     *
     * Output 2:
     *
     *  [[5]]
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  image
     *
     * Explanation 2:
     *
     *  [[1, 1]].[[2, 3]] = [[1 * 2 + 1 * 3]] = [[5]]
     * **/
    public static void main(String[] args) {

    }

    private int[][] solve(int[][] A, int[][] B) {
        int r1 = A.length;
        int c1 = A[0].length;
        int r2 = B.length;
        int c2 = B[0].length;

        if(c1 != r2) {
            int[][] cres = new int[0][0];
            return cres;
        }

        int[][] res = new int[r1][c2];

        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                int val = 0;
                for(int k = 0; k < r2; k++) {
                    val += A[i][k] * B[k][j];
                }
                res[i][j] = val;
            }
        }
        return res;
    }
}
