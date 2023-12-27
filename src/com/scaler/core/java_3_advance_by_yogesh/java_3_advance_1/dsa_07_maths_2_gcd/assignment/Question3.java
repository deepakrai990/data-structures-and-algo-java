package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_07_maths_2_gcd.assignment;

/**
 * @created 17/01/23 11:29 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static int solve(int[] A) {
        int ans = A[0];
        for (int i = 1; i < A.length; i++) {
            ans = gcd(ans, A[i]);
        }
        return ans;
    }

    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 4};
        int result = solve(A);
        System.out.println("Result : " + result);
    }
}
