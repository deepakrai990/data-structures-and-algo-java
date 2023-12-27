package com.scaler.core.java_1_beginner.intro_04_for_loop.assignment;

import java.util.Scanner;

/**
 * @created 28/07/22 5:45 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Is It Prime?
     * Problem Description
     *
     * Given an integer A, you have to tell whether it is a prime number or not.
     *
     * A prime number is a natural number greater than 1 which is divisible only by 1 and itself.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A <= 106
     *
     *
     *
     * Input Format
     *
     * First and only line of the input contains a single integer A.
     *
     *
     *
     * Output Format
     *
     * Print YES if A is a prime, else print NO.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  3
     * Input 2:
     *
     *  4
     *
     *
     * Example Output
     *
     * Output 1:
     *
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
     *  3 is a prime number as it is only divisible by 1 and 3.
     * Explanation 2:
     *
     *  4 is not a prime number as it is divisible by 2.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int countFactor = 0;
        for(int k = 1; k <= A; k++) {
            if(countFactor == 3) {
                break;
            }
            if(A % k == 0) {
                countFactor++;
            }
        }
        if(countFactor == 2) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
