package com.scaler.core.java_3_advance_1.dsa_10_maths_combinatorics.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:43 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Sorted_Permutation_Rank_with_Repeats {
    private static int findRank(String A) {
        int N = A.length();
        int M = 1000003;
        int result = 0;
        int[] factorials = new int[N + 1];
        factorials[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorials[i] = (factorials[i - 1] * i) % M;
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = i + 1; j < N; j++) {
                if (A.charAt(i) > A.charAt(j)) {
                    count++;
                }
            }
            int[] frequency = new int[52];
            for (int j = i; j < N; j++) {
                char c = A.charAt(j);
                if (c <= 'z' && c >= 'a') {
                    frequency[c - 'a'] += 1;
                } else if (c <= 'Z' && c >= 'A') {
                    frequency[c - 'A' + 26] += 1;
                }
            }
            long factVal = 1;
            for (int j = 0; j < 52; j++) {
                if (frequency[j] > 1) {
                    factVal = (factVal * factorials[frequency[j]]) % M;
                }
            }
            long inverse = powmode(factVal, M - 2, M);

            result = (int) ((result % M) + (((count * factorials[N - i - 1]) % M) * inverse % M) % M);
        }
        return result + 1;
    }

    private static int powmode(long A, long B, long M) {
        if (B == 0) return 1;
        long power = powmode(A, B / 2, M);
        if (B % 2 == 0) {
            return (int) ((power * power) % M);
        }
        return (int) ((((power * power) % M) * A) % M);
    }

    public static void main(String[] args) {
        String A = "bca";
        int result = findRank(A);
        PrintUtils.printInt(result);
    }
}
