package com.scaler.core.java_1_beginner.intro_02_if_else_conditions;

/**
 * @created 22/07/22 1:30 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main {
    public static void main(String[] args) {
        int i = 10;
        if (i % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        int a = 10;
        int b = 90;
        int c = 76;

        int largest = 0;
        if (a >= b && a >= c) {
            largest = a;
        } else if (b >= a && b >= c) {
            largest = b;
        } else {
            largest = c;
        }
        System.out.println("Largest Number: " + largest);
    }
}
