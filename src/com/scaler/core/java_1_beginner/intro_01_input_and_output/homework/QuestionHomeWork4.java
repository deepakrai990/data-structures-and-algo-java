package com.scaler.core.java_1_beginner.intro_01_input_and_output.homework;

import java.util.Scanner;

/**
 * @created 21/07/22 12:47 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork4 {
    /**
     * Problem Description
     *
     * Given an english sentence, take it in the input and print it in the output.
     *
     * Input Format
     *
     * Single line containing an english sentence.
     *
     * Output Format
     *
     * Print in a single line the sentence in the input.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strLine = input.nextLine();
        System.out.print(strLine);
    }
}
