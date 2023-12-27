package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_06_maths_1_modular_arithmetic.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 10/02/23 11:20 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int solve(int[] A) {
        int mod = 1000000007;
        int arr[] = new int[1001];
        for (int i = 0; i < A.length; i++) {
            arr[A[i]]++;
        }
        int ans = 0;
        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                ans += ((i % j) * arr[i] * arr[j]) % mod;
                ans %= mod;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {17, 100, 11};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
