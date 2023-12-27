package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.assignment;

/**
 * @created 25/09/22 8:56 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Q4. Minor Diagonal Sum
     * <p>
     * Problem Description
     * You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
     * <p>
     * Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1
     * (where i, j are 1-based).
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
     * Return an integer denoting the sum of minor diagonal elements.
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
     * -5
     * Output 2:
     * <p>
     * 4
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * A[1][3] + A[2][2] + A[3][1] = (-3) + 5 + (-7) = -5
     * Explanation 2:
     * <p>
     * A[1][2] + A[2][1] = 2 + 2 = 4
     **/
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int solve(final int[][] A) {
        int N = A.length;
        int sum = 0;
        int i = 0;
        int j = N - 1;
        while (i < N && j >= 0) {
            sum += A[i][j];
            i++;
            j--;
        }
        return sum;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * This is a simple implementation problem requiring knowledge of loops and 2D arrays.
     * <p>
     * Solution Approach
     * You can iterate through all the elements such that their row number(one-based)
     * and their column number(one-based) adds up to N + 1 i.e i + j = N + 1, and add each of them to the answer.
     **/
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int solve1(final int[][] A) {
        int N = A.length;

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i][N - 1 - i];
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
