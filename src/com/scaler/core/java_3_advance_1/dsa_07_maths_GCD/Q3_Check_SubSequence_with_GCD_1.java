package com.scaler.core.java_3_advance_1.dsa_07_maths_GCD;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 16/09/23 8:55 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Check_SubSequence_with_GCD_1 {
    private static boolean check(int[] a) {
        return gcdArray(a) == 1;
    }
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
        int[] a = {4, 6, 3, 8};
        boolean result = check(a);
        PrintUtils.print(result);
        PrintUtils.printNewLine();
        int[] a1 = {6, 12, 3, 18};
        result = check(a1);
        PrintUtils.print(result);
    }
}
