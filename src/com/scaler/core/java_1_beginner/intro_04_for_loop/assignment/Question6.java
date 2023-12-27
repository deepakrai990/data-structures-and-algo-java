package com.scaler.core.java_1_beginner.intro_04_for_loop.assignment;

import java.util.Scanner;

/**
 * @created 28/07/22 1:22 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        System.out.println("A========= " + A);
        int result = reverse(A);
        System.out.println(result);
    }
    public static int reverse(int A) {
        int result = 0;
        int preResult = 0;
        while(A != 0) {
            int rem = A % 10;
            result = (result * 10) + rem;
            if(((result - rem) /10) != preResult) {
                return 0;
            }
            preResult = result;
            A /= 10;
        }
        return result;
    }
}
