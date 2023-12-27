package com.scaler.core.java_1_beginner.other_classes.function_demo;

import java.util.Scanner;

/**
 * @created 03/08/22 1:02 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Questions1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int radius = in.nextInt();
        int result = solve(radius);

        System.out.println(result);

        double power = Math.pow(2, 3);
        System.out.println(power);
    }

    private static int solve(int A) {
        double areaInDouble = Math.PI * Math.pow(A, 2);
        int result = (int) Math.ceil(areaInDouble);
        /*
        String[] numbers = String.valueOf(areaInDouble).split("\\.");
        int result = Integer.valueOf(numbers[0]);
        if (Long.valueOf(numbers[1]) > 0) {
            result += 1;
        }
        */
        return result;
    }
}
