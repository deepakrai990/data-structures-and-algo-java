package com.scaler.core.java_3_advance_1.dsa_10_maths_combinatorics;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 14/01/24
 * @project scaler_course_code
 */
public class Q1_Find_the_rank {
    /**
     * Problem: Given string with all distinct characters. Find the rank.
     * **/
    // Function to calculate the lexicographic rank of a string
    private static int findLexicographicRank(String str) {
        int rank = 1;
        int n = str.length();
        int[] fact = new int[n];
        Arrays.fill(fact, 0);
        // Calculate the factorial of each position
        for (int i = 0; i < n; i++) {
            fact[i] = factorial(n - i - 1);
        }
        // Calculate the lexicographic rank
        for (int i = 0; i < n; i++) {
            int count = 0;
            // Count the number of characters smaller than str.charAt(i) remaining
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(j) < str.charAt(i)) {
                    count++;
                }
            }
            // Add the contribution to the rank
            rank += count * fact[i];
        }
        return rank;
    }
    // Function to calculate the factorial of a number
    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        String A = "tac";

        int result = findLexicographicRank(A);
        System.out.println("Lexicographic Rank of '" + A + "' is: " + result);
    }
}
