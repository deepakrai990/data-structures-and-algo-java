package com.scaler.core.java_1_beginner.intro_04_for_loop.homework;

import java.util.Scanner;

/**
 * @created 28/07/22 4:36 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int temp;
        while (B > 0) {
            temp = B;
            B = A % B;
            A = temp;
        }
        System.out.println("hcf = " + A);
        in.close();
    }
}
