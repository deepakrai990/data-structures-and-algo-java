package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.assignment;

import java.util.Scanner;

/**
 * @created 23/07/22 1:53 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Write a program to input two numbers(A & B) from user and print the maximum element among A & B in each line.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A <= 1000000
     *
     * 1 <= B <= 1000000
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();

        if(A > B) {
            System.out.print(A);
        } else {
            System.out.print(B);
        }
    }
}
