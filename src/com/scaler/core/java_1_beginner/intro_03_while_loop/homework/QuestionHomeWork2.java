package com.scaler.core.java_1_beginner.intro_03_while_loop.homework;

import java.util.Scanner;

/**
 * @created 26/07/22 3:14 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork2 {
    /**
     * Problem Description
     *
     * You are given two integers A and B. You have to find the value of AB.
     *
     * NOTE: The value of answer is always less than or equal to 109.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A, B <= 1000
     *
     *
     *
     * Input Format
     *
     * First line of the input contains a single integer A.
     *
     * Second line of the input contains a single integer B.
     *
     *
     *
     * Output Format
     *
     * Print a single integer in single line.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  2
     *  3
     * Input 2:
     *
     *  1
     *  10
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  8
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  For A = 2 and B = 3, the value of 23 = 2 * 2 * 2 = 8.
     * Explanation 2:
     *
     *  For A = 1 and B = 10, the value of 110 = 1.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int result = 1;
        while(B > 0) {
            result = result * A;
            B = B - 1;
        }
        System.out.print(result);
    }
}
