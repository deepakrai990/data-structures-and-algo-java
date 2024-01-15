package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class Q2_Calculate_Power_Mod1 {
    /**
     * Problem: Power Mod
     * Given A, N and mod. Calculate (A^N)% mod without any in-built functions
     * **/
    private static long powerMod(long A, long N, long mod) {
        long ans = 1;
        for (int i = 0; i < N; i++) {
            ans = (ans * A) % mod;
        }
        return ans % mod;
    }
    public static void main(String[] args) {
        long A = 5;
        long N = 2;
        long mod = 1000000007;  // Example mod value
        // Calculate (a^n) % mod
        long result = powerMod(A, N, mod);
        // Print the result
        System.out.println("(" + A + "^" + N + ") % " + mod + " = " + result);
    }
}
