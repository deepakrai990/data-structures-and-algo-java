package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.homework;

/**
 * @created 19/09/22 4:07 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Is_Perfect_Square {
    /**
     * Q3. Is Perfect Square ?
     *
     * Problem Description
     * You are given a function that takes an integer argument A. Return 1 if A is a perfect square otherwise return 0.
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 108
     *
     *
     *
     * Input Format
     * First argument is an integer A.
     *
     *
     *
     * Output Format
     * Return an integer (0 or 1) based upon the question.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = 4
     * Input 2:
     *
     * A = 1001
     *
     *
     * Example Output
     * Output 1:
     *
     * 1
     * Output 2:
     *
     * 0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * sqrt(4) = 2
     * Explanation 2:
     *
     * 1001 is not a perfect square.
     * **/
    private static int solve(int A) {
        for(int i = 1; i * i <= A; i++) {
            if((A % i == 0) && (A / i == i)) {
                return 1;
            }
        }
        return 0;
    }
    /**
     * Scaler Solution
     * **/
    private static int solve1(int A) {
        int x = (int) Math.sqrt(A);
        if (x * x == A){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int A = 1001;
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
