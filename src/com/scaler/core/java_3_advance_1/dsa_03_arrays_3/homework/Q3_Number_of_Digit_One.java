package com.scaler.core.java_3_advance_1.dsa_03_arrays_3.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Number_of_Digit_One {
    private static int solve(int A) {
        int base = 1;
        int ans = 0;
        int k;
        while (A / base != 0) {
            k = (base * 10);
            ans += (A / k) * base;
            if ((A % k) / base > 1)
                ans += base;
            if ((A % k) / base == 1)
                ans += A % base + 1;
            base *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 10;
        int result = solve(A);
        PrintUtils.print(result);
    }
}
