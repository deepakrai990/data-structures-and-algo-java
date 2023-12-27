package com.scaler.core.java_3_advance_2.dsa_16_binary_search_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:21 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Ath_Magical_Number {
    private static int solve(int A, int B, int C) {
        //Ath element cannot go beyond Ath multiple of Minimum of B, C.
        long high = ((long) A) * Math.min(B, C);
        //low would be the first multiple of Minimum of B, C.
        long low = Math.min(B, C);
        int mod = 1000000007;

        //Once the search space is defined.
        if (A == 1) return (int) low;

        //To calculate the Ath position divisible by B or C, we need to (imagine) to think of the A multiples of B and C at least(say 5)
        // But we don't need to calculate the common multiple twice.
        //So we need to calculate lcm of B & C, to be able to reduce the common multiple of B and C.
        long lcm = (((long) B) * C) / gcd(B, C);
        long ans = low;

        //Now we are ready to run Binary Search for the search space defined above.
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long countB = mid / B;
            long countC = mid / C;
            //To Reduce the count of common factors.
            long commonFactors = mid / lcm;
            long position = (countB + countC - commonFactors);
            //As we need the Ath Smallest,
            if (position >= A) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        if (ans < 0) {
            ans += mod;
        }
        return (int) (ans % mod);
    }

    private static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        int A = 3; //4;
        int B = 5; //2;
        int C = 35; //3;
        int result = solve(A, B, C);
        PrintUtils.print(result);
    }
}
