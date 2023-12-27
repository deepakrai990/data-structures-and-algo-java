package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_02_arrays_2_two_dimensional.homework;

/**
 * @created 09/02/23 8:40 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    private static int solve(int[][] A) {
        int ansRow = 0;
        int currRow = 0;
        int currCol = A[0].length - 1;

        while (currRow < A.length && currCol >= 0) {
            if (A[currRow][currCol] == 1) {
                currCol--;
                ansRow = currRow;
            } else {
                currRow++;
            }
        }
        return ansRow;
    }

    public static void main(String[] args) {
        int[][] A = {{0, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
        int result = solve(A);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
