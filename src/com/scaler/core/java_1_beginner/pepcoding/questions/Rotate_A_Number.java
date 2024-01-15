package com.scaler.core.java_1_beginner.pepcoding.questions;

import java.util.Scanner;

/**
 * @created 01/08/22 9:04 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Rotate_A_Number {
    /**
     * Input
     * number = 51232
     * noOfTimesToRotate = 2
     *
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int noOfTimesToRotate = in.nextInt();

        int temp = number;
        int noOfDigit = 0;
        while (temp> 0) {
            temp = temp / 10;
            noOfDigit++;
        }

        noOfTimesToRotate = noOfTimesToRotate % noOfDigit;
        if (noOfTimesToRotate < 0) {
            noOfTimesToRotate = noOfTimesToRotate + noOfDigit;
        }

        int divisor = 1;
        int multiplier = 1;
        for (int i = 1; i <= noOfDigit; i++) {
            if (i <= noOfTimesToRotate) {
                divisor = divisor * 10;
            } else {
                multiplier = multiplier * 10;
            }
        }
        int quotient = number / divisor;
        int remainder =  number % divisor;

        int rotatedNumber = remainder * multiplier + quotient;
        System.out.println(rotatedNumber);
        in.close();
    }
}
