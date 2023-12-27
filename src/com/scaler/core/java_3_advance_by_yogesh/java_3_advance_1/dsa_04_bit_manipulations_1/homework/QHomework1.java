package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_04_bit_manipulations_1.homework;

/**
 * @created 10/02/23 8:14 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static String solve(int[] A) {
        int l = A.length;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum = sum + A[i];
        }
        if (sum % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        int[] A = {9, 17};
        String result = solve(A);
        System.out.printf("%s%5s", "Result: ", result);
    }
}
