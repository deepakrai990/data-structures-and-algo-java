package com.scaler.core.java_2_intermediate.dsa_02_time_complexity_1;

/**
 * @author Deepak Kumar Rai
 * @created 30/12/23
 * @project scaler_course_code
 */
public class GeometricProgression {
    // Function to calculate the n-th term of a geometric progression
    private static int calculateNthTerm(int a, int r, int n) {
        return a * (int) Math.pow(r, n - 1);
    }

    // Function to calculate the sum of the first n terms of a geometric progression
    private static int calculateSumOfTerms(int a, int r, int n) {
        return a * (int) ((Math.pow(r, n) - 1) / (r - 1));
    }
    public static void main(String[] args) {
        int a = 2; // first term
        int r = 3; // common ratio
        int n = 4; // number of terms

        // Calculate the n-th term
        int An = calculateNthTerm(a, r, n);
        System.out.println("The " + n + "-th term is: " + An);

        // Calculate the sum of the first n terms
        int Sn = calculateSumOfTerms(a, r, n);
        System.out.println("The sum of the first " + n + " terms is: " + Sn);
    }
}
