package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.assignment;

/**
 * @created 19/09/22 2:00 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_IsPrime {
    private static int solve(Long A) {
        if(isPrime(A)) {
            return 1;
        } else {
            return 0;
        }
    }
    private static boolean isPrime(Long A) {
        int count = 0;
        for(long i = 1L; i <= Math.sqrt(A); i++) {
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
        return count == 2;
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
