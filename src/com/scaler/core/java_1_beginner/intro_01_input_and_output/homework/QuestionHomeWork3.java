package com.scaler.core.java_1_beginner.intro_01_input_and_output.homework;

import java.util.Scanner;

/**
 * @created 21/07/22 12:41 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork3 {
    /**
     * You will be given a float in input. You need to add 10 to it and print the result to output.
     *
     * Input Format
     *
     * One float value in input.
     *
     * Output Format
     *
     * Print a single float the sum.
     *
     * Problem Constraints
     *
     * 1 <= N <= 1000
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float N = input.nextFloat();
        float result = N + 10;
        System.out.print(String.format("%.0f", result));
    }
}
