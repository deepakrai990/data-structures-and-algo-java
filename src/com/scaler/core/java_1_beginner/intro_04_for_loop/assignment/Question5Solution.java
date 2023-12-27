package com.scaler.core.java_1_beginner.intro_04_for_loop.assignment;

import java.util.Scanner;

/**
 * @created 28/07/22 5:48 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t > 0) {
            int N = scn.nextInt();
            int count = 0;
            if (N == 0) {
                System.out.println(1);
            } else {
                while (N > 0) {
                    count++;
                    N = N / 10;
                }
                System.out.println(count);
            }
            t--;
        }
    }
}
