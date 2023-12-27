package com.scaler.core.java_3_advance_1.dsa_06_maths_modular_arithmetic;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 12/09/23 11:41 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class InverseModulo {

    private static int solve(int a, int b) {
        int g = gcd(a, b);
        if (g != 1) return 0;
        // If A and B are relatively prime, then modulo
        // inverse is A^(B-2) mod B
        return (int) power(a, b - 2, b);
    }
    private static long power(long x, long y, long p) {
        long res = 1;        // Initialize result
        x = x % p;        // Update x if it is more than or equal to p
        while (y > 0) {
            // If y is odd, multiply x with a result
            if ((y & 1) == 1L)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static long powerModulo(long base, long exponent, long modulo) {
        if (modulo == 1) {
            return 0; // Any number modulo 1 is 0.
        }
        long result = 1;
        base = base % modulo;
        while (exponent > 0) {
            // If exponent is odd, multiply base with a result
            if (exponent % 2 == 1) {
                result = (result * base) % modulo;
            }
            // exponent must be even now
            exponent = exponent >> 1; // equivalent to exponent = exponent / 2
            base = (base * base) % modulo;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 23;
        int result = solve(a, b);
        PrintUtils.print(result);
        PrintUtils.print(powerModulo(2, 10, 10000007));
    }
}
