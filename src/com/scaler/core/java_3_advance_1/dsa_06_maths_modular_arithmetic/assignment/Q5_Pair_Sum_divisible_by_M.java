package com.scaler.core.java_3_advance_1.dsa_06_maths_modular_arithmetic.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_Pair_Sum_divisible_by_M {
    private static int solve(int[] A, int B) {
        int N = A.length;
        long[] count = new long[B];
        for (int i = 0; i < N; i++) {
            int rem = A[i] % B;
            count[rem]++;
        }

        long ans = 0;
        long x = count[0];
        ans += (x * (x - 1)) / 2;

        if (B % 2 == 0) {
            long y = count[B / 2];
            ans += (y * (y - 1)) / 2;
        }

        //normal cases
        int i = 1;
        int j = B - 1;

        while (i < j) {
            ans += count[i] * count[j];
            i++;
            j--;
        }
        return (int) (ans % 1000000007);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 2;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
