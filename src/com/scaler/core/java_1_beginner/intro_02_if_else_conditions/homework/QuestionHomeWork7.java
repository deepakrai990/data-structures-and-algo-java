package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.homework;

import java.util.Scanner;

/**
 * @created 23/07/22 3:11 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork7 {
    /**
     * Problem Description
     *
     * You are given an integer A. You have to tell whether A is divible by both 5 and 11 or not.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A <= 109
     *
     *
     *
     * Input Format
     *
     * The input contains a single integer A.
     *
     *
     *
     * Output Format
     *
     * Print 1 if A is divisible by both 5 and 11, else print 0.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  55
     * Input 2:
     *
     *  22
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  0
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  55 is divisible by both 5 (5 * 11 = 55) and 11 (11 * 5 = 55).
     * Explanation 2:
     *
     *  22 is divisble by 11 (11 * 2 = 22),but it is not divisible by 5.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        if (A % 5 == 0 && A % 11 == 0) {
            System.out.print(1);
        } else {
            System.out.print(1);
        }
    }
}
