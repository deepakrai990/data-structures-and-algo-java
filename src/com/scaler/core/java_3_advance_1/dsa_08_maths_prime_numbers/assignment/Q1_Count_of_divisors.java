package com.scaler.core.java_3_advance_1.dsa_08_maths_prime_numbers.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:45 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Count_of_divisors {
    private static int[] solve(int[] A) {
        int n = A.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(A[i], max);
        }

        int[] countOfFactors = new int[max + 1];
        countOfFactors[1] = 1;
        for (int i = 2; i <= max; i++) {
            countOfFactors[i] = 2;
        }

        //Count factors from 2 to max
        for (int i = 2; i <= max; i++) {
            for (int j = 2 * i; j <= max; j += i) {
                countOfFactors[j] = countOfFactors[j] + 1;
            }
        }

        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = countOfFactors[A[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 4, 5};
        int[] results = solve(A);
        PrintUtils.print1DArray(results);
    }
}
