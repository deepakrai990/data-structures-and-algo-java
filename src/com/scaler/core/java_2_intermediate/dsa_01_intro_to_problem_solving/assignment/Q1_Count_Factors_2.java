package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.assignment;

/**
 * @created 19/09/22 1:55 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Count_Factors_2 {
    /**
     * Q1. Count Factors - 2
     *
     * Problem Description
     * Given an integer A, you need to find the count of it's factors.
     *
     * Factor of a number is the number which divides it perfectly leaving no remainder.
     *
     * Example : 1, 2, 3, 6 are factors of 6
     *
     *
     * Problem Constraints
     * 1 <= A <= 109
     *
     *
     * Input Format
     * First and only argument is an integer A.
     *
     *
     * Output Format
     * Return the count of factors of A.
     *
     *
     * Example Input
     * Input 1:
     * 5
     * Input 2:
     * 10
     *
     *
     * Example Output
     * Output 1:
     * 2
     * Output 2:
     * 4
     *
     *
     * Example Explanation
     * Explanation 1:
     * Factors of 5 are 1 and 5.
     * Explanation 2:
     * Factors of 10 are 1, 2, 5 and 10.
     * **/
    private static int solve(int A) {
        int count = 0;
        for(int i = 1; i <= Math.sqrt(A); i++) {
            if(A % i == 0) {
                if(i != A / i) {
                    count += 2;
                } else {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * Scaler Solution
     * **/
    private static int solve1(int A) {
        int count = 0;
        for(int i = 1 ; i * i <= A ; i++){
            if(A % i == 0){
                count += 1;
                if(i * i != A){
                    count += 1;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int A = 10;
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
