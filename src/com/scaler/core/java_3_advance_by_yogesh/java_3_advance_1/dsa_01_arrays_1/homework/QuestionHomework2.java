package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1.homework;

import java.util.Arrays;

/**
 * @created 04/01/23 5:23 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QuestionHomework2 {
    private static int[] flip(String A) {
        int[] result = new int[2];
        int N = A.length();
        int start = 0;
        int end = 0;
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < N; i++) {
            if (A.charAt(i) == '0') {
                currentSum++;
            } else {
                currentSum--;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                end = i;
                result[0] = start + 1;
                result[1] = end + 1;
            }
            if (currentSum < 0) {
                currentSum = 0;
                start = i + 1;
            }
        }

        if (result[0] == 0 && result[1] == 0) {
            return new int[0];
        }
        return result;
    }

    public static void main(String[] args) {
        String A = "010";
        int[] results = flip(A);
        System.out.println(Arrays.toString(results));
    }
}
