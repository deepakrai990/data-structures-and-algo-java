package com.scaler.core.java_3_advance_1.dsa_08_maths_prime_numbers.homework;

import java.util.HashSet;
import java.util.Set;

/**
 * @created 02/04/23 7:48 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Distinct_Primes {
    private static int solve(int[] A) {
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int temp = A[i];
            for (int j = 2; j * j <= temp; j++) {
                if (temp % j == 0) {
                    set.add(j);
                    while (temp % j == 0)
                        temp /= j;
                }
            }
            if (temp > 1)
                set.add(temp);
        }
        return set.size();
    }
}
