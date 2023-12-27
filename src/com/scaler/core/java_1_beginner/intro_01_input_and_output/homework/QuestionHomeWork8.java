package com.scaler.core.java_1_beginner.intro_01_input_and_output.homework;

import java.util.Scanner;

/**
 * @created 21/07/22 1:40 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // total budget
        float N = input.nextFloat();
        // value of a single bill
        int M = input.nextInt();

        int totalNoOfBills = (int) N / M;
        System.out.print(totalNoOfBills);
    }
}
