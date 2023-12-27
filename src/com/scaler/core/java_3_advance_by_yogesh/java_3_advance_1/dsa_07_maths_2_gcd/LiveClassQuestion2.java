package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_07_maths_2_gcd;

/**
 * @created 05/02/23 1:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    public static void main(String[] args) {
        int[] a = {8, 16, 12, 10};
        int result = findGcdOfArray(a);
        System.out.printf("%s%5d", "Result : ", result);
    }

    private static int findGcdOfArray(int[] a) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans = gcd(ans, a[i]);
        }
        return ans;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static int gcd1(int A, int B) {
        if (B == 0)
            return A;
        return gcd1(B, A % B);
    }
}
