package com.scaler.core.java_1_beginner.intro_06_patterns2;

import java.util.Scanner;

/**
 * @created 06/08/22 7:09 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PatterQuestion3 {
    /**
     * print pattern
     *
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     *
     * input n = 5
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int r = 1; r <= n; r++) {
            int starCount = 2 * r - 1;
            int spaceCount = n - r;
            for (int space = 1; space <= spaceCount; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= starCount; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
