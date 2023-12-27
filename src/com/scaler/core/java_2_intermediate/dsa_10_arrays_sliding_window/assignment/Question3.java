package com.scaler.core.java_2_intermediate.dsa_10_arrays_sliding_window.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 13/09/22 2:33 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Spiral Order Matrix II
     *
     * Problem Description
     * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 1000
     *
     *
     *
     * Input Format
     * First and only argument is integer A
     *
     *
     * Output Format
     * Return a 2-D matrix which consists of the elements added in spiral order.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * 1
     * Input 2:
     *
     * 2
     * Input 3:
     *
     * 5
     *
     *
     * Example Output
     * Output 1:
     *
     * [ [1] ]
     * Output 2:
     *
     * [ [1, 2], [4, 3] ]
     * Output 2:
     *
     * [ [1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9] ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Only 1 is to be arranged.
     * Explanation 2:
     *
     * 1 --> 2
     *       |
     *       |
     * 4<--- 3
     *
     * **/
    private static int[][] generateMatrix(int n) {
        int a[][] = new int[n][n];
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        int c = 1;
        while(c <= n * n){
            for(int i = top; i <= right; i++ ){
                a[top][i] = c;
                c++;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                a[i][right] = c;
                c++;
            }
            right--;
            for(int i = right; i >= left; i--){
                a[bottom][i] = c;
                c++;
            }
            bottom--;
            for(int i = bottom; i >= top; i--){
                a[i][left] = c;
                c++;
            }
            left++;
        }
        return a;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] results = generateMatrix(n);
        PrintUtils.print2DArray(results);
    }
}
