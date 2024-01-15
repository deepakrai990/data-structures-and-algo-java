package com.scaler.core.java_1_beginner.pepcoding.questions.pattern;

import java.util.Scanner;

/**
 * @created 01/08/22 9:50 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Pattern2Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        for (int i = 0; i < N; i++) { // 0, 1, 2, 3, 4
            for (int j = 1; j <= (N - i); j++) { // 5, 4, 3, 2, 1
                System.out.print("*\t");
            }
            System.out.println();
        }
        scn.close();
    }
}
