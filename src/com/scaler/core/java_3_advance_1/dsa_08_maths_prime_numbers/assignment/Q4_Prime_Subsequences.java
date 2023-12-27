package com.scaler.core.java_3_advance_1.dsa_08_maths_prime_numbers.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 7:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Prime_Subsequences {
    private static int solve(int[] A) {
        int N = A.length;
        long c = 0;
        int mod = 1000000007;
        int M = 1000005;
        int res = 0;
        boolean p[] = new boolean[M];
        Arrays.fill(p, true);
        p[1] = false;

        for (int i = 2; i * i < M; i++) {
            if (p[i]) {
                for (int j = i * i; j < M; j += i) {
                    p[j] = false;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (p[A[i]]) {
                c++;
            }
        }
        res = (int) ((int) (Math.pow(2, c) % mod));
        return res - 1;
    }
}
