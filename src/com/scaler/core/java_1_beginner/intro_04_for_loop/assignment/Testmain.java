package com.scaler.core.java_1_beginner.intro_04_for_loop.assignment;

import java.util.Scanner;

/**
 * @created 28/07/22 1:03 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
class Testmain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int reverse = 0;
        int rem;
        int temp = A;
        while(temp != 0) {
            rem = temp % 10;
            reverse = (reverse * 10) + rem;
            temp /= 10;
        }
        if(A == reverse) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
        in.close();
    }

    public static boolean isArmstrongNumber(int num) {
        int sum = 0, rightDigit, temp;
        temp = num;
        while (temp != 0) {
            rightDigit = temp % 10;
            sum = sum + (rightDigit * rightDigit * rightDigit);
            temp = temp / 10;
        }
        /*
         * Check if sum is equal to N, then N is a armstrong number otherwise
         * not an armstrong number
         */
        if (sum == num) {
            // N is armstrong number
            return true;
        } else {
            // N is not an armstrong number
            return false;
        }
    }
}
