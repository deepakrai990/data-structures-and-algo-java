package com.scaler.core.java_1_beginner.intro_07_functions.assignments;

import java.util.Scanner;

/**
 * @created 04/08/22 12:36 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Least Common Multiple
     *
     * Problem Description
     * Write a program to input an integer T and then for each test case input two integers A and B in two different lines and then print T lines containing Least Common Multiple (LCM) of two given 2 numbers A and B.
     *
     * LCM of two integers is the smallest positive integer divisible by both.
     *
     *
     *
     * Problem Constraints
     * 1 <= T <= 1000
     *
     * 1 <= A,B <= 1000
     *
     *
     *
     * Input Format
     * In first-line input T which means number of test cases.
     *
     * Next 2T lines contains input A and B for each testcase.
     * First line of each testcase contain an integer A and second line of the testcase contains input B.
     *
     *
     *
     * Output Format
     *
     *
     * T lines each containing an integer representing LCM of A & B.
     *
     *
     *
     * Example Input
     * Input 1:
     * 3
     * 2
     * 3
     * 9
     * 6
     * 2
     * 6
     *
     *
     * Example Output
     * Output 1:
     * 6
     * 18
     * 6
     *
     *
     * Example Explanation
     * Explanation:
     *
     *  In first testcase 6 is the smallest positive integer which is divisible by both 2 (2 * 3 = 6) and 3 (3 * 2 = 6).
     *  In second testcase 18 is the smallest positive integer which is divisible by both 9 (9 * 2 = 18) and 6 (6 * 3 = 18).
     *  In third testcase  6 is the smallest positive integer which is divisible by both 2 (2 * 3 = 6) and 6 (6 * 1 = 6).
     * **/
    public static int gcd(int A, int B) {
        if (B != 0)
            return gcd(B, A % B);
        else
            return A;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 1; i <= T; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int result = (A * B) / gcd(A, B);
            System.out.println(result);
        }
    }
}
