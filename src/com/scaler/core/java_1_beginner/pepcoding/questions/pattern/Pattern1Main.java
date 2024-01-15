package com.scaler.core.java_1_beginner.pepcoding.questions.pattern;

import java.util.Scanner;

/**
 * @created 01/08/22 11:50 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Pattern1Main {
    /**
     * Input 5
     * pattern will like
     *         *
     *         *    *
     *         *    *   *
     *         *    *   *   *
     *         *    *   *   *   *
     * **/
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
        scn.close();
    }
}
