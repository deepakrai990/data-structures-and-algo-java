package com.scaler.core.java_1_beginner.intro_01_input_and_output.homework;

import java.util.Scanner;

/**
 * @created 21/07/22 12:37 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork2 {
    /**
     * Given 5 numbers A, B, C, D, E as input. Print the average of these 5 numbers (correct up to 2 decimal places).
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();
        int D = input.nextInt();
        int E = input.nextInt();
        double allAddition = Double.valueOf(String.valueOf((A + B + C + D + E)));
        double result = allAddition / 5d;
        System.out.print(String.format("%.2f", result));
    }
}
