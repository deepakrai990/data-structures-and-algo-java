package com.scaler.core.java_1_beginner.intro_03_while_loop.homework;

import java.util.Scanner;

/**
 * @created 26/07/22 3:16 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork5 {
    /**
     * Problem Description
     *
     * Given a number A. Print all perfect squares less than or equal to A.
     *
     * Notes - Perfect squares are integers whose square root is an integer.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A <= 104
     *
     *
     *
     * Input Format
     *
     * A single line consisting of a integer A.
     *
     *
     *
     * Output Format
     *
     * Print perfect squares less than or equal to A in a single line in a space-separated manner.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * 20
     * Input 2:
     *
     * 100
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * 1 4 9 16
     * Output 2:
     *
     * 1 4 9 16 25 36 49 64 81 100
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int i = 1;
        while(i * i <= A) {
            System.out.print((i * i) + " ");
            i = i + 1;
        }
    }
}
