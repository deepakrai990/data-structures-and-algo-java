package com.scaler.core.java_1_beginner.intro_06_patterns2;

import java.util.Scanner;

/**
 * @created 02/08/22 9:22 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PatterQuestion2 {
    /**
     * Print pattern
     *
     * *        *
     * **      **
     * ***    ***
     * ****  ****
     * **********
     *
     * input N = 5
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int r = 1; r <= N; r++) {
            int starCount = r;
            int spaceCount = 2 * (N - r);
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
        in.close();
    }
}
