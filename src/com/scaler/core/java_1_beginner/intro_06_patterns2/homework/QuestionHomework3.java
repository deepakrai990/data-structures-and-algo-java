package com.scaler.core.java_1_beginner.intro_06_patterns2.homework;

import java.util.Scanner;

/**
 * @created 06/08/22 7:24 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework3 {
    /**
     * Q3. Half Diamond
     *
     * Problem Description
     *
     * Given an integer N, print the corresponding Half Diamond pattern with 2*N - 1 rows.
     *
     * For example if N = 5 then pattern will be like:
     *
     * *
     * **
     * ***
     * ****
     * *****
     * ****
     * ***
     * **
     * *
     * NOTE: There should be no spaces after any * .
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
     * Output the Half Diamond pattern corresponding to the given N.
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
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  *
     *  **
     *  *
     * Output 2:
     *
     *  *
     *  **
     *  ***
     *  **
     *  *
     *
     *
     * Example Explanation
     *
     *  Print the pattern as described.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int r = 1; r <= n; r++) {
            for(int j = 1; j <= r; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int r = 1; r <= n; r++) {
            for(int j = 1; j <= n - r; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        in.close();
    }
}
