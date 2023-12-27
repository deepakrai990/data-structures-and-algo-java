package com.scaler.core.java_1_beginner.intro_01_input_and_output.assignment;

import java.util.Scanner;

/**
 * @created 21/07/22 11:43 AM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int totalTime = 40;
        int remainingTime = totalTime - N;
        System.out.print(remainingTime);
    }
}
