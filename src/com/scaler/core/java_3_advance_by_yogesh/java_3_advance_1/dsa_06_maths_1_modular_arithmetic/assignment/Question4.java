package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_06_maths_1_modular_arithmetic.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 10/02/23 10:53 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question4 {
    private static int solve(int A, int B) {
        long fact = 1;
        long mod = (long) (1e9 + 7);
        for (long i = 2; i <= B; i++) {
            fact = (fact * i) % (mod - 1);
        }
        int ans = fast_power(A, fact, mod);
        return ans;
    }

    private static int fast_power(long A, long B, long mod) {
        long ans = 1;
        while (B > 0) {
            if ((B & 1) == 1) {
                ans = (ans * A) % mod;
            }
            A = (A % mod * A % mod) % mod;
            B = B >> 1;
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 2;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
