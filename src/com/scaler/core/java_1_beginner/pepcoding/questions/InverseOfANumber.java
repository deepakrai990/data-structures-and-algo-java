package com.scaler.core.java_1_beginner.pepcoding.questions;

import java.util.Scanner;

/**
 * @created 31/07/22 5:02 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class InverseOfANumber {
    /**
     *
     * Input 613254
     * 
     * 5 4 3 2 1   position
     * 2 1 4 5 3   value
     *
     * value will be position for inverse and position will be value
     *
     * Inverse
     * 5 4 3 2 1   position
     * 2 3 1 5 4   value
     *
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int inverse = 0;
        int originalPosition = 1;
        printPositionAndValue(false, "Original");
        while (n != 0) {
            int originalDigit = n % 10;
            int invertedDigit = originalPosition;
            int invertedPlace = originalDigit;

            printPositionAndValue(originalPosition, originalDigit);

            /** make change to inverse using invertedPlace and InvertedDigit **/

            inverse = inverse + (invertedDigit * (int) Math.pow(10, invertedPlace - 1));

            n /= 10;
            originalPosition++;
        }
        printPositionAndValue(true, "Original");
        System.out.println(inverse);
    }
    private static void printPositionAndValue(boolean isSingleLine, String positionName) {
        if (isSingleLine) {
            System.out.println("----------------------"+positionName+"----------------------");
            return;
        }
        System.out.println("----------------------"+positionName+"----------------------");
        System.out.printf("%s", "position");
        System.out.printf("%15s", "value");
        System.out.println();
    }

    private static void printPositionAndValue(int originalPosition, int originalDigit) {
        System.out.printf("%4d %15d\n", originalPosition, originalDigit);
    }
}
