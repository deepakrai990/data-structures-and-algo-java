package com.scaler.core.java_1_beginner.intro_07_functions.homework;

import java.util.Scanner;

/**
 * @created 06/08/22 7:59 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1 {
    /**
     * Q1. Decimal to Binary - II
     *
     * Problem Description
     * You are given an integer A in decimal (base 10).
     * Return an integer denoting the binary (base 2) form of the integer A.
     *
     *
     * Problem Constraints
     * 1 <= A <= 10^2
     *
     *
     * Input Format
     * Function stub has a single integer A, denoting the integer for that test case.
     *
     *
     * Output Format
     * Return an integer denoting the binary representation of A.
     *
     *
     * Example Input
     * 10
     *
     *
     * Example Output
     * 1010
     *
     *
     * Example Explanation
     * The binary form of 10 is given by -> 1010
     * **/
    private static int solve(int A) {
        long binaryNumber = 0;
        int i = 1;
        while(A != 0) {
            int remainder = A % 2;
            A /= 2;
            binaryNumber += (remainder * i);
            i *= 10;
        }
        return (int) binaryNumber;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int result = solve(A);
        System.out.println(result);
        Math.pow(2, 4);
    }

}
