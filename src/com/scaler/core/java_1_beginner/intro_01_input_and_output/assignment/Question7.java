package com.scaler.core.java_1_beginner.intro_01_input_and_output.assignment;

import java.util.Scanner;

/**
 * @created 21/07/22 11:54 AM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // No of layers
        int N = input.nextInt();
        // time the lasagna has already spent baking in the oven
        int M = input.nextInt();

        int noForEachlayers = 2;

        int totalElapsedTime = (N * noForEachlayers) + M;

        System.out.print(totalElapsedTime);
    }
}
