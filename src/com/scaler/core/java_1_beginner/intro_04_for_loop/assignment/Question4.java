package com.scaler.core.java_1_beginner.intro_04_for_loop.assignment;

import java.util.Scanner;

/**
 * @created 28/07/22 5:46 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Q4. Is It Perfect?
     * Problem Description
     *
     * You are given N positive integers.
     *
     * For each given integer A, you have to tell whether it is a perfect number or not.
     *
     * A perfect number is a positive integer which is equal to the sum of its proper positive divisors.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 10
     *
     * 1 <= A <= 106
     *
     *
     *
     * Input Format
     *
     * The first line of the input contains a single integer N.
     *
     * Each of the next N lines contains a single integer A.
     *
     *
     *
     * Output Format
     *
     * In a separate line, print YES if a given integer is perfect, else print NO.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  2
     *  4
     *  6
     * Input 2:
     *
     *  1
     *  3
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  NO
     *  YES
     * Output 2:
     *
     *  NO
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  For A = 4, the answer is "NO" as sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
     *  For A = 6, the answer is "YES" as sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.
     * Explanation 2:
     *
     *  For A = 3, the answer is "NO" as sum of its proper divisors = 1, is not equal to 3.
     * **/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int k = 1; k <= N; k++) {
            int A = in.nextInt();
            int sum = 1;
            for(int p = 2; p < A; p++) {
                if(A % p == 0) {
                    sum += p;
                }
            }
            if(A == sum) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
