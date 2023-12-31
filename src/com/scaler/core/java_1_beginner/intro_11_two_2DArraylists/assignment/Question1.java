package com.scaler.core.java_1_beginner.intro_11_two_2DArraylists.assignment;

/**
 * @created 18/08/22 2:29 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. Is It Identity Matrix?
     *
     * Problem Description
     *
     * You are given a N X N square integer matrix A. You have to tell whether A is an identity matrix or not.
     *
     * Identity matrix is a special square matrix whose main diagonal elements are equal to 1 and all other elements are 0.
     *
     *
     *
     * Problem Constraints
     *
     * 2 <= N <= 103
     *
     * A[i][j] equals 0 or 1.
     *
     *
     *
     * Input Format
     *
     * First and only argument is an integer matrix A.
     *
     *
     * Output Format
     *
     * Return 1 if A is an identity matrix, else return 0.
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  [[1, 0]
     *   [0, 1]]
     *
     * Input 2:
     *
     *  [[0, 0, 1]
     *   [0, 1, 0]
     *   [1, 0, 0]]
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  1
     *
     * Output 2:
     *
     *  0
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  All the main diagonal elements in A are 1, all other elements are 0.
     *  So, A is an identity matrix.
     *
     * Explanation 2:
     *
     *  All the main diagonal elements in A are not 1, also all other elements are not equal to 0.
     *  So, A is not an identity matrix.
     * **/
    public static void main(String[] args) {

    }
    private static int solve(final int[][] A) {
        int rows = A.length;
        int columns = A[0].length;
        if(rows != columns){
            return 0;
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(i == j && A[i][j] != 1){
                    return 0;
                }
                if(i != j && A[i][j] != 0){
                    return 0;
                }
            }
        }
        return 1;
    }
}
