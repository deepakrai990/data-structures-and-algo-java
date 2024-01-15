package com.scaler.core.java_1_beginner.intro_03_while_loop;

import java.util.Scanner;

/**
 * @created 26/07/22 1:16 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /**
         * Q6 Print numbers from 1 to N which are multiple of 4.
         * Ex: N = 50
         * -> 4 8 12 16 20 24 28 32 36 40 44 48
         * **/
        //  4 * i [i from 1 to N]
        //  smallest multiple is 4
        // method 1
        int n = input.nextInt();
        int i = 4;
        System.out.println("--------------method 1--------------");
        while(i <= n) {
            System.out.println(i);
            i = i + 4;
        }

        // printing -> 4 * i
        // i is starting from i
        // i is updating by 1, i.e. i = i + 1
        // 4 * 1 = 4
        // 4 * 2 = 8
        // 4 * 3 = 12
        // .
        // .
        // .
        // .
        // 4 * 12 = 48
        // condition -> 4 * i <= n
        // method 2
        System.out.println("--------------method 2--------------");
        int n1 = input.nextInt();
        int i1 = 1;
        while(4 * i1 <= n1) {
            System.out.println(4 * i1);
            i1 = i1 + 1;
        }

        // method 3
        System.out.println("--------------method 2--------------");
        int n2 = input.nextInt();
        int i2 = 1;
        while(i2 <= n2) {
            if(i2 % 4 == 0) {
         		System.out.println(i2);
            }
        	i2 = i2 + 1;
        }
        input.close();
    }
}
