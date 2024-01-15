package com.scaler.core.java_1_beginner.intro_05_patterns1;

import java.util.Scanner;

/**
 * @created 30/07/22 12:12 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PatterQuestion1 {
    /**
     * Print pattern
     *
     * *
     * * *
     * * * *
     * * * * *
     * * * * * *
     *
     * input n = 5
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        in.close();
    }
}
