package com.scaler.core.java_1_beginner.intro_06_patterns2.homework;

import java.util.Scanner;

/**
 * @created 06/08/22 7:22 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1 {
    /**
     * Q1. Pattern 20826
     * Given an integer N. Print the following pattern of N lines.
     *
     * Input:-
     *
     * 5
     *
     * Output:-
     *
     * *_____*
     *
     * *____*
     *
     * *___*
     *
     * *__*
     *
     * *_*
     *
     * Here '_' represents space for explanation purposes only. You have to print actual spaces in your code.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.print("*");
            for(int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
    }
}
