package com.scaler.core.java_3_advance_1.dsa_07_maths_GCD;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 16/09/23 8:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Calculate_GCD_of_Array {
    private static int gcdArray(int[] a) {
        int ans = a[0];
        for (int i = 1; i < a.length; i++) {
            ans = gcd(ans, a[i]);
        }
        return ans;
    }
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] a = {8, 16, 12, 10};
        int result = gcdArray(a);
        PrintUtils.print(result);
    }
}
