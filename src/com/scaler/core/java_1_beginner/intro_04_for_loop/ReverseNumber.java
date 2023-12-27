package com.scaler.core.java_1_beginner.intro_04_for_loop;

import java.util.Scanner;

/**
 * @created 28/07/22 11:09 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int result = 0;
        while (N > 0) {
            result = result * 10 + (N % 10);
            N = N / 10;
        }
        System.out.println(result);
    }
}
