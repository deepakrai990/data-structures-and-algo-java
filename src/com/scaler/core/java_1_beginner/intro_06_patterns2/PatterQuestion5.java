package com.scaler.core.java_1_beginner.intro_06_patterns2;

import java.util.Scanner;

/**
 * @created 06/08/22 7:18 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PatterQuestion5 {
    /**
     * Print pattern
     *
     * 0 0 0 0 1 0 0 0 0
     * 0 0 0 2 3 2 0 0 0
     * 0 0 3 4 5 4 3 0 0
     * 0 4 5 6 7 6 5 4 0
     * 5 6 7 8 9 8 7 6 5
     *
     * input n = 5
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int row = 1; row <= n; row++) {
            int spaceCount = n - row;
            int starCount = 2 * row - 1;
            // space
            for(int space = 1; space <= spaceCount; space++) {
                System.out.print("0 ");
            }
            // value
            int val = row;
            for(int star = 1; star <= starCount; star++) {
                System.out.print(val + " ");
                if(star <= starCount / 2) {
                    val++;
                } else {
                    val--;
                }
            }
            // sapce
            for(int space = 1; space <= spaceCount; space++) {
                System.out.print("0 ");
            }
            System.out.println();
        }

    }
}
