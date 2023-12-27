package com.scaler.core.java_3_advance_1.dsa_08_maths_prime_numbers;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @created 19/09/23 12:05 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Find_All_Smallest_Prime_Factors {
    private static int[] findAllSmallestPrimeFactors(int n) {
        int[] spf = new int[n + 1];
        for (int i = 0; i < n; i++) {
            spf[i] = i;
        }
        spf[0] = spf[1] = 1;
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }

    public static void main(String[] args) {
        int n = 50;
        int[] results = findAllSmallestPrimeFactors(n);
        PrintUtils.print1DArray(results);
    }
}
