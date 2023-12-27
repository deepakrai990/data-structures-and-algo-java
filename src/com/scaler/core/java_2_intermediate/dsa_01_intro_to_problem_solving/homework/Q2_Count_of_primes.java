package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.homework;

/**
 * @created 19/09/22 4:05 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Count_of_primes {
    /**
     * Q2. Count of primes
     *
     * Problem Description
     * You will be given an integer n. You need to return the count of prime numbers less than or equal to n.
     *
     *
     * Problem Constraints
     * 0 <= n <= 10^3
     *
     *
     * Input Format
     * Single input parameter n in function.
     *
     *
     * Output Format
     * Return the count of prime numbers less than or equal to n.
     *
     *
     * Example Input
     * Input 1: 19
     * Input 2: 1
     *
     *
     * Example Output
     * Output 1: 8
     * Output 2: 0
     *
     *
     * Example Explanation
     * Explanation 1: Primes <= 19 are 2, 3, 5, 7, 11, 13, 17, 19
     * Explanation 2: There are no primes <= 1
     * **/
    private static int solve(int A) {
        int count = 0;
        for(int i = 1; i <= A; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int A) {
        int count = 0;
        for(int i = 1; i <= Math.sqrt(A); i++) {
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
    private static int solve1(int A) {
        int cnt = 0;
        for(int i=1 ; i<=A ; i++){
            int factors = 0;
            for(int j=1;j<=i;j++) {
                if(i%j==0){
                    factors++;
                }
            }
            if(factors==2) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int A = 19;
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
