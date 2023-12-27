package com.scaler.core.java_1_beginner.intro_06_patterns2;

import java.util.Scanner;

/**
 * @created 02/08/22 1:04 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PatterQuestion1 {
    /**
     * print this pattern
     * **********
     * ****  ****
     * ***    ***
     * **      **
     * *        *
     *
     * take input as 5
     *
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int row = 0; row < n; row++) {
            int starCount = (n - row);
            int spaceCount = row * 2;
            for (int star = 1; star <= starCount; star++) {
                System.out.print("*");
            }
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
