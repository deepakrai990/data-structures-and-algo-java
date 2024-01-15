package com.scaler.core.java_1_beginner.intro_06_patterns2;

import java.util.Scanner;

/**
 * @created 06/08/22 7:20 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PatterQuestion6 {
    /**
     * Print Pattern
     *
     * 0 0 0 0 5 0 0 0 0
     * 0 0 0 4 8 12 0 0 0
     * 0 0 3 6 9 12 15 0 0
     * 0 2 4 6 8 10 12 14 0
     * 1 2 3 4 5 6 7 8 9
     *
     * input n = 5
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int r = 1; r <= n; r++) {
            int zeroCount = n - r;
            int digitCount = 2 * r - 1;
            for(int zero = 1; zero <= zeroCount; zero++) {
                System.out.print("0 ");
            }
            for(int digit = 1; digit <= digitCount; digit++) {
                System.out.print((n - r + 1) * digit + " ");
            }
            for(int zero = 1; zero <= zeroCount; zero++) {
                System.out.print("0 ");
            }
            System.out.println();
        }
        in.close();
    }
}
