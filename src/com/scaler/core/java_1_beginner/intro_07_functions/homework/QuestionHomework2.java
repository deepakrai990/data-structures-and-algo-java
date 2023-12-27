package com.scaler.core.java_1_beginner.intro_07_functions.homework;

import java.util.Scanner;

/**
 * @created 06/08/22 8:00 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework2 {
    /**
     * Q2. Binary to Decimal - II
     *
     * Problem Description
     * You are given a number A in binary format (Base = 2). You have to print the number in decimal format (Base = 10).
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 210
     *
     *
     *
     * Input Format
     * First and only line contains a single binary number A.
     *
     *
     *
     * Output Format
     * Print in a single line, a decimal integer.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  11
     * Input 2:
     *
     *  1011
     *
     *
     * Example Output
     * Output 1:
     *
     *  3
     * Output 2:
     *
     *  11
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  (0011)2 = (21 + 20)10 = (3)10
     * Explanation 2:
     *
     *  (1010)2 = (23+ 21 + 20)10 = (11)10
     * **/
    public static int convertBinaryToDecimal(long A) {
        int decimalNumber = 0;
        int i = 0;
        while(A != 0) {
            long remainder = A % 10;
            A /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }
        return decimalNumber;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long A = in.nextLong();
        int result = convertBinaryToDecimal(A);
        System.out.print(result);
    }


}
