package com.scaler.core.java_1_beginner.intro_06_patterns2;

import java.util.Scanner;

/**
 * @created 03/08/22 7:09 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PatternQuestionHomeWork {
    /**
     * Print this pattern
     *      *
     *     ***
     *    *****
     * ***********
     *  *********
     *   *******
     *   *******
     *  *********
     * ***********
     *    *****
     *     ***
     *      *
     * Take input as 3 or what your wish
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n; space++) {
                System.out.print(" ");
            }
            for (int space = 1; space <= (n - row); space++) {
                System.out.print(" ");
            }

            for (int star = 1; star <= (row * 2) - 1 ; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < row ; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < n - row ; i++) {
                System.out.print("*");
            }
            for (int i = 0; i < n * 2 - 1 ; i++) {
                System.out.print("*");
            }
            for (int i = 0; i < n - row ; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = 0; row < n; row++) {
            for (int i = 1; i < n - row ; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i <= row; i++) {
                System.out.print("*");
            }
            for (int i = 0; i < n * 2 - 1 ; i++) {
                System.out.print("*");
            }
            for (int i = 0; i <= row; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < n ; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < row; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < n - row; i++) {
                System.out.print("*");
            }
            for (int i = 1; i < n - row; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        in.close();
    }
}
