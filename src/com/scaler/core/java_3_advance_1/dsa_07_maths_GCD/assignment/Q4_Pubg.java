package com.scaler.core.java_3_advance_1.dsa_07_maths_GCD.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Pubg {
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
        PrintUtils.print(result);
    }
}
