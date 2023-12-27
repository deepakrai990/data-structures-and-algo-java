package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.assignment;

/**
 * @created 19/09/22 3:24 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Square root of a number
     *
     * Problem Description
     *
     * Given a number A. Return square root of the number if it is perfect square otherwise return -1.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A <= 108
     *
     *
     *
     * Input Format
     *
     * First argument is an integer A.
     *
     *
     *
     * Output Format
     *
     * Return an integer which is the square root of A if A is perfect square otherwise return -1.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * A = 4
     * Input 2:
     *
     * A = 1001
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * 2
     * Output 2:
     *
     * -1
     *
     *
     * Example Explanation
     *
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
                return i;
            }
        }
        return -1;
    }
    /**
     * Scaler Solution
     * **/
    private static int solve1(int A) {
        for(int i = 1; i <= 10000; i++){
            if(i * i == A){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int A = 1001;
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
