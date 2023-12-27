package com.scaler.core.java_1_beginner.intro_05_patterns1;

import java.util.Scanner;

/**
 * @created 02/08/22 8:01 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PatterQuestion6 {
    /**
     * Print pattern
     *
     * *    *
     * *   *
     * *  *
     * * *
     * **
     *
     * input n = 5
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
    }
}
