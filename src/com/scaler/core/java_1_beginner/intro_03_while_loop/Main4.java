package com.scaler.core.java_1_beginner.intro_03_while_loop;

import java.util.Scanner;

/**
 * @created 26/07/22 1:07 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /**
         * Q3 Print odd numbers from 1 to N.
         * Ex: N = 10
         * -> 1 3 5 7 9
         * **/
        // method 1
        int n = input.nextInt();
        int i = 1;
        System.out.println("--------------method 1--------------");
        while(i <= n) {
            if(i % 2 != 0) {
            	System.out.println(i);
            }
            i = i + 1;
        }
        // i = 1 2 3 4 5 6 7 8 9 10
        // method 2
        System.out.println("--------------method 2--------------");
        int i1 = 1;
        while(i1 <= n) {
            System.out.println(i1);
            i1 = i1 + 2;
        }
        // N = 10
        // iteration required in method 1 -> 10 iterations
        // iteration required in method 2 -> 5 iterations

        // method 2 is efficient
    }
}
