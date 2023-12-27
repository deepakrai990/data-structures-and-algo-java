package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.assignment;

/**
 * @created 25/09/22 8:52 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Main Diagonal Sum
     * <p>
     * Problem Description
     * You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.
     * <p>
     * Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 103
     * <p>
     * -1000 <= A[i][j] <= 1000
     * <p>
     * <p>
     * <p>
     * Input Format
     * First and only argument is a 2D integer matrix A.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return an integer denoting the sum of main diagonal elements.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [[1, -2, -3],
     * [-4, 5, -6],
     * [-7, -8, 9]]
     * Input 2:
     * <p>
     * A = [[3, 2],
     * [2, 3]]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 15
     * Output 2:
     * <p>
     * 6
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * A[1][1] + A[2][2] + A[3][3] = 1 + 5 + 9 = 15
     * Explanation 2:
     * <p>
     * A[1][1] + A[2][2] = 3 + 3 = 6
     **/
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int solve(final int[][] A) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int N = A.length;
        while (i < N && j < N) {
            sum += A[i][j];
            i++;
            j++;
        }
        return sum;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * Initialize a answer variable with 0.
     * And add all main diagonal elements to it.
     * <p>
     * Solution Approach
     * Matrix is square.
     * So, just loop on number of rows (i.e. N) and add main diagonal element value
     * to the answer variable.
     **/
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int solve1(final int[][] A) {
        int N = A.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {{1, -2, -3}, {-4, 5, -6}, {-7, -8, 9}};
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
