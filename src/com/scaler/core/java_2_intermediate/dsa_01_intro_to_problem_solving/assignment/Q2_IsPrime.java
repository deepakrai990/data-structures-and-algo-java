package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.assignment;

/**
 * @created 19/09/22 2:00 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_IsPrime {
    /**
     * Q2. IsPrime
     *
     * Problem Description
     * Given an Integer A. Return 1 if A is prime and return 0 if not.
     *
     *
     * Problem Constraints
     * 1 <= A <= 1012
     *
     *
     * Input Format
     * The first argument is a single integer A.
     *
     *
     * Output Format
     * Return 1 if A is prime else return 0.
     *
     *
     * Example Input
     * Input 1:
     * A = 5
     * Input 2:
     *
     * A = 10
     *
     *
     * Example Output
     * Output 1:
     * 1
     * Output 2:
     *
     * 0
     *
     *
     * Example Explanation
     * Explanation 1:
     * 5 is a prime number.
     * Explanation 2:
     *
     * 10 is not a prime number.
     * **/
    private static int solve(Long A) {
        if(isPrime(A)) {
            return 1;
        } else {
            return 0;
        }
    }
    private static boolean isPrime(Long A) {
        int count = 0;
        for(Long i = 1L; i <= Math.sqrt(A); i++) {
            if(count >= 3) {
                return false;
            }
            if(A % i == 0) {
                if(i != A / i) {
                    count += 2;
                } else {
                    count++;
                }
            }
        }
        if(count == 2) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Scaler Solution
     * **/
    private static int solve1(Long A) {
        if(A==1) return 0;
        for(long i = 2; i * i <= A; i++){
            if(A % i == 0) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Long A = 10L;
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
