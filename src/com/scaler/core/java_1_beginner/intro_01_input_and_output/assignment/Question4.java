package com.scaler.core.java_1_beginner.intro_01_input_and_output.assignment;

import java.util.Scanner;

/**
 * @created 21/07/22 10:18 AM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();

        System.out.print((A + B) + " ");
        System.out.print((A * B) + " ");
        System.out.print((A - B) + " ");
        System.out.print(A / B);
    }
}
