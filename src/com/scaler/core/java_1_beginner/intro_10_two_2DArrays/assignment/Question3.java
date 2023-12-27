package com.scaler.core.java_1_beginner.intro_10_two_2DArrays.assignment;

/**
 * @created 18/08/22 6:51 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Row Sum
     *
     * Problem Description
     *
     * You are given a 2D integer matrix A, return a 1D integer vector containing row-wise sums of original matrix.
     *
     *
     * Problem Constraints
     *
     * 1 <= A.size() <= 103
     *
     * 1 <= A[i].size() <= 103
     *
     * 1 <= A[i][j] <= 103
     *
     *
     *
     * Input Format
     *
     * First argument is a vector of vector of integers.(2D matrix).
     *
     *
     * Output Format
     *
     * Return a vector conatining row-wise sums of original matrix.
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * [1,2,3,4]
     * [5,6,7,8]
     * [9,2,3,4]
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * {10,26,18}
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1
     *
     * Row 1 = 1+2+3+4 = 10
     * Row 2 = 5+6+7+8 = 26
     * Row 3 = 9+2+3+4 = 18
     * **/
    private static int[] solve(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        int[] arr = new int[row];

        for (int i = 0; i < row; i++) {
            int sumOfColumn = 0;
            for (int j = 0; j < column; j++) {
                sumOfColumn += A[i][j];
            }
            arr[i] = sumOfColumn;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[][] arr  = {{1, 4}, {2, 3}};
        solve(arr);
    }
}
