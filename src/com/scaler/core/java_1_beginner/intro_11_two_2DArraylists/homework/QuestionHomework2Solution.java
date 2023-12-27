package com.scaler.core.java_1_beginner.intro_11_two_2DArraylists.homework;

/**
 * @created 18/08/22 6:24 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework2Solution {
    public static void main(String[] args) {

    }

    private static int[][] solve(int[][] A, int B) {
        int row = A.length, col = A[0].length;
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                A[i][j] *= B;
        return A;
    }
}
