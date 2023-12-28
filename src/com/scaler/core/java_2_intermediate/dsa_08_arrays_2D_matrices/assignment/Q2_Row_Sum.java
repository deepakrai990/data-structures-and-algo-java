package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.assignment;

/**
 * @created 25/09/22 8:48 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Row_Sum {
    /**
     * Q2. Row Sum
     * <p>
     * Problem Description
     * You are given a 2D integer matrix A, return a 1D integer array containing row-wise sums of original matrix.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A.size() <= 103
     * <p>
     * 1 <= A[i].size() <= 103
     * <p>
     * 1 <= A[i][j] <= 103
     * <p>
     * <p>
     * <p>
     * Input Format
     * First argument A is a 2D array of integers.(2D matrix).
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return an array conatining row-wise sums of original matrix.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * [1,2,3,4]
     * [5,6,7,8]
     * [9,2,3,4]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * {10,26,18}
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1
     * <p>
     * Row 1 = 1+2+3+4 = 10
     * Row 2 = 5+6+7+8 = 26
     * Row 3 = 9+2+3+4 = 18
     **/
    private static int[] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[] rowSums = new int[rows];
        for (int i = 0; i < rows; i++) {
            int rSum = 0;
            for (int j = 0; j < cols; j++) {
                rSum += A[i][j];
            }
            rowSums[i] = rSum;
        }
        return rowSums;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * Just check row by row and keep storing their sum in a vector.
     * <p>
     * Solution Approach
     * Iterate the 2D vector row wise and by storing sum of a row in a variable and push it in a vector
     * after the completion of each row.
     **/
    private static int[] solve1(int[][] A) {
        int n = A.length, m = A[0].length;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                temp += A[i][j];
            }
            ans[i] = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 2, 3, 4}};
        int[] results = solve(A);
        System.out.println("Results : " + results);
        results = solve1(A);
        System.out.println("Results : " + results);
    }
}
