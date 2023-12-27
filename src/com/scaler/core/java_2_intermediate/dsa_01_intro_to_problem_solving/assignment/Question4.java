package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.assignment;

/**
 * @created 19/09/22 3:26 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Q4. Sum of evens!
     *
     * Problem Description
     *
     * You are given an integer A, you need to find and return the sum of all the even numbers between 1 and A.
     *
     * Even numbers are those numbers that are divisible by 2.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 500
     *
     *
     *
     * Input Format
     *
     * First and only argument is an integer A.
     *
     *
     *
     * Output Format
     *
     * Return an integer denoting the sum of even numbers between [1, A] (both inclusive).
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  5
     * Input 2:
     *
     *  2
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  6
     * Output 2:
     *
     *  2
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  Even numbers between [1, 5] are (2, 4).
     * Explanation 2:
     *
     *  Even numbers between [1, 2] are (2)
     * **/
    private static int solve(int A) {
        int sum = 0;
        for(int i = 2; i <= A; i += 2) {
            sum += i;
        }
        return sum;
    }
    /**
     * Scaler Solution
     * **/
    private static int solve1(int A) {
        int sum = 0;
        for (int i = 2; i <= A; i++){
            if (i % 2 == 0)
                sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        int A = 5;
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
