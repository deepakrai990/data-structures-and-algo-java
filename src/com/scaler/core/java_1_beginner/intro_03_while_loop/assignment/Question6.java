package com.scaler.core.java_1_beginner.intro_03_while_loop.assignment;

import java.util.Scanner;

/**
 * @created 26/07/22 3:24 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question6 {
    /**
     * Q6. Multiples of 4
     * Problem Description
     * Given an integer input N, print all multiples of 4 less than or equal to N.
     *
     *
     * Problem Constraints
     * 1 <= N <= 10000
     *
     *
     * Input Format
     * Single line containing an integer N.
     *
     *
     * Output Format
     * Space separated integers representing multiples of 4 less than or equal to N.
     *
     *
     * Example Input
     * 22
     *
     *
     * Example Output
     * 4 8 12 16 20
     *
     *
     * Example Explanation
     * 1 * 4 = 4
     * 2 * 4 = 8
     * 3 * 4 = 12
     * 4 * 4 = 16
     * 5 * 4 = 20
     *
     * All are multiples of 4 less than 22
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int i = 1;
        while (4 * i <= N) {
            System.out.print((4 * i) + " ");
            i = i + 1;
        }
    }
}
