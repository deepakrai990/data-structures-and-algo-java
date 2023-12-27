package com.scaler.core.java_1_beginner.intro_11_two_2DArraylists.homework;

/**
 * @created 18/08/22 6:22 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1 {
    /**
     * Q1. Row & Column Sums
     *
     * Problem Description
     *
     * You are given a matrix A, you have to return an array containing sum of each row elements followed by each
     * column elements of the matrix .
     *
     * NOTE: In the resultant array of integers, there will be rows+columns elements where ans[i] is the
     * sum of ith row elements and ans[rows+j] is the sum of jth column.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A.size() <= 1000
     *
     * 1 <= A[i].size() <= 1000
     *
     * 1 <= A[i][j] <= 1000
     *
     *
     *
     * Input Format
     *
     * First argument is vector of vector of integers representing matrix A.
     *
     *
     *
     * Output Format
     *
     * You have to return a vector of integers after doing required operations.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * A = [[1, 2],[4, 5],[8, 9]]
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * [3, 9, 17, 13, 16]
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * Row 1 elements sum = 1 + 2 = 3.
     * Row 2 elements sum = 4 + 5 = 9.
     * Row 3 elements sum = 8 + 9 = 17.
     * Column 1 elements sum = 1 + 4 + 8 = 13.
     * Column 2 elements sum = 2 + 5 + 9 = 16.
     * **/
    public static void main(String[] args) {

    }

    private int[] solve(int[][] A) {
        int[] result = new int[A.length + A[0].length];
        int resultArrayLength = 0;
        for(int row = 0; row < A.length; row++) {
            int sumOfRows = 0;
            for(int column = 0; column < A[0].length; column++) {
                sumOfRows += A[row][column];
            }
            result[resultArrayLength] = sumOfRows;
            resultArrayLength++;
        }
        for(int column = 0; column < A[0].length; column++) {
            int sumOfRows = 0;
            for(int row = 0; row < A.length; row++) {
                sumOfRows += A[row][column];
            }
            result[resultArrayLength] = sumOfRows;
            resultArrayLength++;
        }
        return result;
    }
}
