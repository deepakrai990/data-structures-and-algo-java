package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.assignment;

/**
 * @created 25/09/22 8:40 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Column_Sum {
    /**
     * Q1. Column Sum
     * <p>
     * Problem Description
     * You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.
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
     * First argument is a 2D array of integers.(2D matrix).
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return an array conatining column-wise sums of original matrix.
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
     * {15,10,13,16}
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1
     * <p>
     * Column 1 = 1+5+9 = 15
     * Column 2 = 2+6+2 = 10
     * Column 3 = 3+7+3 = 13
     * Column 4 = 4+8+4 = 16
     **/
    private static int[] solve(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;
        int[] columnSums = new int[columns];
        for (int column = 0; column < columns; column++) {
            int columnsSum = 0;
            for (int row = 0; row < rows; row++) {
                columnsSum += A[row][column];
            }
            columnSums[column] = columnsSum;
        }
        return columnSums;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * Just check column by column and keep storing their sum in a vector.
     * <p>
     * Solution Approach
     * Iterate the 2D vector column wise and by storing sum of a column in a variable and push it in a vector
     * after the completion of each column.
     **/
    private static int[] solve1(int[][] A) {
        int n = A.length, m = A[0].length;
        int[] ans = new int[m];
        for (int j = 0; j < m; j++) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp += A[i][j];
            }
            ans[j] = temp;
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
