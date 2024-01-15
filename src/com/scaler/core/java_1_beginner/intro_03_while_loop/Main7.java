package com.scaler.core.java_1_beginner.intro_03_while_loop;

import java.util.Scanner;

/**
 * @created 26/07/22 1:23 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /**
         * Q7 Print numbers from 1 to N, which are perfect Square.
         * N = 100
         * -> 1 4 9 16 25 36 49 64 81 100
         * **/
        // sqrt(10) = 3.xyz
        // that means 10 is perfect Square, because sqrt of 10 is not
        // integral numbers


        // sqrt(49) = 7
        // 49 is perfect square?


        // num = i * i
        // 1 = 1 * 1
        // 4 = 2 * 2
        // 9 = 3 * 3
        // 16 = 4 * 4
        // 25 = 5 * 5
        // 36 = 6 * 6
        // 49 = 7 * 7
        // 64 = 8 * 8
        // 81 = 9 * 9
        // 100 = 10 * 10

        int n = input.nextInt();
        int i = 1;
        while(i * i <= n) {
            System.out.println(i * i);
            i = i + 1;
        }

        /**
         i <= 3 (n)
         i		condition	loop work  update
         1.	i = 1     true			done	i = 1 + 1 = 2
         2.  i = 2     true 			done	i = 2 + 1 = 3
         3.  i = 3     true			done	i = 3 + 1 = 4
         4.  i = 4     false -> discard this iteration -> loop will break

         total iteration is n
         **/
        input.close();
    }
}
