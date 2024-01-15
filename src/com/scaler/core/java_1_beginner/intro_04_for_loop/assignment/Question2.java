package com.scaler.core.java_1_beginner.intro_04_for_loop.assignment;

import java.util.Scanner;

/**
 * @created 28/07/22 5:44 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Q2. Count factors
     * Problem Description
     *
     * Given an integer N in the input, you need to print the count of it's factors.
     *
     * Factor of a number is the number which divides it perfectly leaving no remainder.
     *
     * Example : 1, 2, 3, 6 are factors of 6
     *
     * Problem Constraints
     *
     * 1 <= N <= 300
     *
     * Input Format
     *
     * First and only line of input contains a single integer N.
     *
     * Output Format
     *
     * Print the count of factors of N.
     *
     * Example Input
     *
     * Input 1:
     *  5
     * Input 2:
     *  10
     *
     * Example Output
     *
     * Output 1:
     * 2
     * Output 2:
     * 4
     *
     * Example Explanation
     *
     * Explanation 1:
     *  Factors of 5 are 1 and 5.
     * Explanation 2:
     *  Factors of 10 are 1, 2, 5 and 10.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int factorCount = 0;
        for(int i = 1; i <= N; i++) {
            if(N % i == 0) {
                factorCount++;
            }
        }
        System.out.print(factorCount);
        in.close();
    }
}
