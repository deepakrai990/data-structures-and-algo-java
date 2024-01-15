package com.scaler.core.java_1_beginner.intro_01_input_and_output.assignment;

import java.util.Scanner;

/**
 * @created 21/07/22 11:59 AM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String A = input.nextLine();
        String B = input.nextLine();
        System.out.print(A + " says Hi to " + B);
        input.close();
    }
}
