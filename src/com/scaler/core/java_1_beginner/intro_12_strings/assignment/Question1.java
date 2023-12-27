package com.scaler.core.java_1_beginner.intro_12_strings.assignment;

import java.util.Scanner;

/**
 * @created 18/08/22 1:54 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. Length of String
     *
     * Problem Description
     *
     * Write a program to input an integer T and then each of T lines will have a string (S).
     *
     * You have to print T lines each containing length of input string.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= T <= 100
     *
     * 1 <= S.size() <= 1000
     *
     *
     *
     * Input Format
     *
     * First line is T which means number of test cases.
     *
     * Each next T lines contain a string S.
     *
     *
     *
     * Output Format
     *
     * T lines each containing an integer representing length of the input string.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * 2
     * scaler
     * interviewbit
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * 6
     * 12
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 1; i <= T; i++) {
            String str = in.next();
            System.out.println(str.length());
        }
    }
}
