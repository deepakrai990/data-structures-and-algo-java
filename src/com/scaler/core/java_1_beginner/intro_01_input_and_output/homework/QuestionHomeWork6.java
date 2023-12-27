package com.scaler.core.java_1_beginner.intro_01_input_and_output.homework;

import java.util.Scanner;

/**
 * @created 21/07/22 1:27 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork6 {
    /**
     * Problem Description
     *
     * Given a name A as input. Print "Hello A", where A is the name in input.
     *
     *
     * Problem Constraints
     *
     * 1 <= len(A) <= 15
     * Characters in A are in lowercase English Alphabets.
     *
     *
     * Input Format
     *
     * There is a single input line, which is the string A.
     *
     *
     * Output Format
     *
     * Print in a single line "Hello A" without quotes.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String A = input.next();
        System.out.print("Hello " + A);
    }
}
