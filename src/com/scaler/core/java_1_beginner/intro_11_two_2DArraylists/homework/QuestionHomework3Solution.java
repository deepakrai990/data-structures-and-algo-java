package com.scaler.core.java_1_beginner.intro_11_two_2DArraylists.homework;

/**
 * @created 18/08/22 6:24 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework3Solution {
    public static void main(String[] args) {

    }

    private static int solve(final int[][] A) {
        int N = A.length;

        int sum = 0;
        for (int i = 0; i < N;i++){
            sum += A[i][i];
        }

        return sum;
    }
}
