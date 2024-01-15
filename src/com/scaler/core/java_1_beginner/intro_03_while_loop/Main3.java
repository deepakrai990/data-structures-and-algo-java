package com.scaler.core.java_1_beginner.intro_03_while_loop;

import java.util.Scanner;

/**
 * @created 26/07/22 1:05 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /**
         * Q1 Print numbers from 1 to N.
         * N = 7
         * -> 1 2 3 4 5 6 7
         * **/
        int n = input.nextInt();
        int i = 1;
        while(i <= n) {
            System.out.print(i + " ");
            i = i + 1;
        }
        input.close();
    }
}
