package com.scaler.core.java_3_advance_1.dsa_07_maths_GCD;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_DeleteOne {

    private static int deleteOne(int[] a) {
        int n = a.length;
        int[] pfGcd = new int[n]; // Prefix gcd pfGcd[i] = gcd of all elements [0 i]
        int[] sfGcd = new int[n]; // Suffix gcd sfGcd[i] = gcd of all elements [i n - 1]

        pfGcd[0] = a[0];
        for (int i = 1; i < n; i++) {
            pfGcd[i] = gcd(pfGcd[i - 1], a[i]);
        }

        sfGcd[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i --) {
            sfGcd[i] = gcd(sfGcd[i + 1], a[i]);
        }
        /*
        * Edge Case: to delete a[0]         =>  sfGcd[1]
        *            to delete a[n - 1]     =>  pfGcd[n - 2]
        * */
        int ans = Math.max(pfGcd[n - 2], sfGcd[1]);
        for (int i = 1; i < n - 2; i++) {
            // Delete a[i] & get gcd of remaining elements
            int left = pfGcd[i - 1];
            int right = sfGcd[i + 1];
            int val = gcd(left, right);
            ans = Math.max(ans, val);
        }
        return ans;
    }
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] a = {24, 16, 18, 30, 15};
        int result = deleteOne(a);
        PrintUtils.print(result);
    }
}
