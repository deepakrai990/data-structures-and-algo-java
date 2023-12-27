package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.homework;

/**
 * @created 19/09/22 4:02 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    /**
     * Q1. Find Perfect Numbers
     * <p>
     * Problem Description
     * You are given an integer A. You have to tell whether it is a perfect number or not.
     * <p>
     * Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
     * <p>
     * A proper divisor of a natural number is the divisor that is strictly less than the number.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A <= 106
     * <p>
     * <p>
     * <p>
     * Input Format
     * First and only argument contains a single positive integer A.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return 1 if A is a perfect number and 0 otherwise.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = 4
     * Input 2:
     * <p>
     * A = 6
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 0
     * Output 2:
     * <p>
     * 1
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * For A = 4, the sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
     * Explanation 2:
     * <p>
     * For A = 6, the sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.
     **/
    private static int solve(int A) {
        int sum = 1;
        for (int i = 2; i * i <= A; i++) {
            if (A % i == 0) {
                if (i * i != A)
                    sum = sum + i + A / i;
                else
                    sum = sum + i;
            }
        }
        if (sum == A && A != 1) {
            return 1;
        }

        return 0;
    }

    /**
     * Scaler Solution
     **/
    private static int solve1(int A) {
        if (A == 1) {
            return 0;
        }
        int sum = 1;
        for (int j = 2; j * j <= A; j++) {
            if (A % j == 0) {
                sum += j;
                if (j != A / j) {
                    sum += A / j;
                }
            }
        }
        if (sum == A) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int A = 6;
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);

    }
}
