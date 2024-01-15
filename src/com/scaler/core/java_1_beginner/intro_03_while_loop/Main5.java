package com.scaler.core.java_1_beginner.intro_03_while_loop;

import java.util.Scanner;

/**
 * @created 26/07/22 1:13 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /**
         * Q4 Print even numbers from 1 to N.
         * Ex: N = 10
         * -> 2 4 6 8 10
         * **/
        int n = input.nextInt();
        // method 1
        int i = 1;
        System.out.println("--------------method 1--------------");
        while(i <= n) {
            if(i % 2 == 0) {
                // i is even
                System.out.println(i);
            }
         	i = i + 1;
        }
        // method 2
        System.out.println("--------------method 2--------------");
        int i1 = 2;
        while(i1 <= n) {
            System.out.println(i1);
            i1 = i1 + 2;
        }
        input.close();
    }
}
