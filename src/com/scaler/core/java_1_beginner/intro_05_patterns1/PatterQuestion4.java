package com.scaler.core.java_1_beginner.intro_05_patterns1;

import java.util.Scanner;

/**
 * @created 02/08/22 7:45 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PatterQuestion4 {
    /**
     * Print pattern
     *
     * 1
     * 1 *
     * 1 * 3
     * 1 * 3 *
     * 1 * 3 * 5
     *
     * input n = 5
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j % 2 == 1) {
                    System.out.print(j +" ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        in.close();
    }
}
