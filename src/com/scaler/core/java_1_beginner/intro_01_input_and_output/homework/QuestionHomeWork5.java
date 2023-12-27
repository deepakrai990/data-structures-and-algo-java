package com.scaler.core.java_1_beginner.intro_01_input_and_output.homework;

import java.util.Scanner;

/**
 * @created 21/07/22 1:24 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork5 {
    /**
     * Problem Description
     *
     * Given an integer in the input print its last digit.
     *
     * Input Format
     *
     * Single line containing an integer.
     *
     * Output Format
     *
     * Print in a single line the last digit of input integer.
     *
     * Problem Constraints
     *
     * 1 <= N <= 1000
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int lastDigitOfN = N % 10;
        System.out.print(lastDigitOfN);
    }
}
