package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_02_arrays_2_two_dimensional.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 19/01/23 11:57 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static int solve(int[][] A, int B) {
        int row = 0;
        int col = A[0].length - 1;
        while (col >= 0 && row < A.length) {
            int currElement = A[row][col];
            if (currElement == B) {
                if (col != 0 && A[row][col - 1] == B) {
                    col--;
                } else {
                    return (row + 1) * 1009 + col + 1;
                }
            } else if (currElement < B) {
                row++;
            } else if (currElement > B) {
                col--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int B = 2;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
