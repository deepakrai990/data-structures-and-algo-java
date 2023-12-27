package com.scaler.core.java_1_beginner.intro_01_input_and_output.homework;

import java.util.Scanner;

/**
 * @created 21/07/22 12:02 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();

        System.out.print(A+""+B);
        System.out.println("\n-------------------");
        double d = 2.456534;
        System.out.println("Double upto 2 decimal places: "+String.format("%.2f",d));
    }
}
