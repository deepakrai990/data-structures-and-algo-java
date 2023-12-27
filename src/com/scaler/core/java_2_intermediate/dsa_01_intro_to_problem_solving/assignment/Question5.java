package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.assignment;

/**
 * @created 19/09/22 3:29 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    /**
     * Q5. Power function
     * Problem Description
     *
     * You are given two integers A and B.
     *
     * You have to find the value of AB.
     *
     * NOTE: The value of answer is always less than or equal to 109.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A, B <= 1000
     *
     *
     *
     * Input Format
     *
     * First parameter is an integer A.
     *
     * Second parameter is an integer B.
     *
     *
     *
     * Output Format
     *
     * Return an integer.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  A = 2
     *  B = 3
     * Input 2:
     *
     *  A = 1
     *  B = 10
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  8
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  For A = 2 and B = 3, the value of 23 = 2 * 2 * 2 = 8.
     * Explanation 2:
     *
     *  For A = 1 and B = 10, the value of 110 = 1.
     * **/
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    private static int power(final int A, final int B) {
        int result = 1;
        int base = A;
        int exponent = B;
        while (exponent != 0) {
            result *= base;
            --exponent;
        }
        return result;
    }
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    private static int power1(final int A, final int B) {
        int ans = 1;

        for (int i = 1; i <= B;i++){
            ans *= A;
        }

        return ans;
    }
    public static void main(String[] args) {
        int A = 1;
        int B = 10;
        int result = power(A, B);
        System.out.println("Result : " + result);
        result = power1(A, B);
        System.out.println("Result : " + result);
    }
}
