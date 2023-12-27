package com.scaler.core.java_1_beginner.pepcoding.questions;

import java.util.Scanner;

/**
 * @created 31/07/22 4:52 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class ReverseANumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            result = (result * 10) + digit;
            n /= 10;
        }
        System.out.println();
        System.out.println(result);
    }
}
