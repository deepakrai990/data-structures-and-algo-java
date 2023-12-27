package com.scaler.core.java_1_beginner.intro_04_for_loop.assignment;

import java.util.Scanner;

/**
 * @created 28/07/22 7:04 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int n = scn.nextInt();
            int first = 0;
            int last = 0;
            last = n % 10;
            while(n > 0) {
                first = n % 10;
                n = n / 10;
            }
            System.out.println(first + " " + last);
        }
    }
}
