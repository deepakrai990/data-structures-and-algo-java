package com.scaler.core.java_2_intermediate.dsa_02_time_complexity_1;

/**
 * @author Deepak Kumar Rai
 * @created 30/12/23
 * @project scaler_course_code
 */
public class ArithmeticProgression {
    // Function to calculate the n-th term of an arithmetic progression
    private static int calculateNthTerm(int a, int d, int n) {
        return a + (n - 1) * d;
    }

    // Function to calculate the sum of the first n terms of an arithmetic progression
    private static int calculateSumOfTerms(int a, int d, int n) {
        return n / 2 * (2 * a + (n - 1) * d);
    }
    public static void main(String[] args) {
        int a = 3; // first term
        int d = 5; // common difference
        int n = 4; // number of terms

        // Calculate the n-th term
        int An = calculateNthTerm(a, d, n);
        System.out.println("The " + n + "-th term is: " + An);

        // Calculate the sum of the first n terms
        int Sn = calculateSumOfTerms(a, d, n);
        System.out.println("The sum of the first " + n + " terms is: " + Sn);
    }
}
