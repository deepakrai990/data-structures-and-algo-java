package com.scaler.core.java_1_beginner.intro_06_patterns2.assignment;

import java.util.Scanner;

/**
 * @created 06/08/22 7:28 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Full Numeric Pyramid
     *
     * Problem Description
     *
     * Given an integer N, print the corresponding Full Numeric Pyramid pattern for N.
     *
     * For example if N = 5 then pattern will be like:
     *
     * 0 0 0 0 1 0 0 0 0
     * 0 0 0 2 3 2 0 0 0
     * 0 0 3 4 5 4 3 0 0
     * 0 4 5 6 7 6 5 4 0
     * 5 6 7 8 9 8 7 6 5
     *
     * NOTE: There should be exactly one extra space after each number for each row.
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
     * NOTE:
     *
     * There is no extra space before the first integer of any row.
     * There is an extra space after the last integer of any row.
     * All the integers in any row are space separated.
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
     * 0 1 0
     * 2 3 2
     * Output 2:
     *
     * 0 0 1 0 0
     * 0 2 3 2 0
     * 3 4 5 4 3
     *
     *
     *
     * Example Explanation
     *
     *  Print the pattern as described.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int row = 1; row <= n; row++) {
            int spaceCount = n - row;
            int starCount = 2 * row - 1;
            // space
            for(int space = 1; space <= spaceCount; space++) {
                System.out.print("0 ");
            }
            // value
            int val = row;
            for(int star = 1; star <= starCount; star++) {
                System.out.print(val + " ");
                if(star <= starCount / 2) {
                    val++;
                } else {
                    val--;
                }
            }
            // sapce
            for(int space = 1; space <= spaceCount; space++) {
                System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
