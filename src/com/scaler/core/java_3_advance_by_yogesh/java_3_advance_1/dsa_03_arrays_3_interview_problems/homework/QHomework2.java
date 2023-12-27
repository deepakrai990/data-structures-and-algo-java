package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_03_arrays_3_interview_problems.homework;

/**
 * @created 10/02/23 12:28 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
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
        System.out.printf("%s%5d", "Result: ", result);
    }
}
