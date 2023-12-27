package com.scaler.core.java_1_beginner.intro_06_patterns2.assignment;

import java.util.Scanner;

/**
 * @created 06/08/22 7:29 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Q4. Full pyramid
     *
     * Problem Description
     *
     * Given an integer N, print the corresponding Full Pyramid pattern for N.
     *
     * For example if N = 5 then pattern will be like:
     *
     *     *
     *    * *
     *   * * *
     *  * * * *
     * * * * * *
     * NOTE: There should be exactly one extra space after each * for each row.
     *
     *
     *
     * Problem Constraints
     *
     * 2 <= N <= 100
     *
     *
     *
     * Input Format
     *
     * First and only line of input contains a single integer N.
     *
     *
     *
     * Output Format
     *
     * Output the Full Pyramid pattern corresponding to the given N.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  2
     * Input 2:
     *
     *  3
     * Input 3:
     *
     *  4
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *   *
     *  * *
     * Output 2:
     *
     *    *
     *   * *
     *  * * *
     * Output 3:
     *
     *     *
     *    * *
     *   * * *
     *  * * * *
     *
     *
     *
     * Example Explanation
     *
     *  Print the pattern as described.
     * **/
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int row = 1; row <= n; row++) {
            int spaceCount = n - row;
            for(int space = 1; space <= spaceCount; space++){
                System.out.print(" ");
            }
            for(int star = 1; star <= row; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
