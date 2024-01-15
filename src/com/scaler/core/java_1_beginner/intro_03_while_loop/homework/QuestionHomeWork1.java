package com.scaler.core.java_1_beginner.intro_03_while_loop.homework;

import java.util.Scanner;

/**
 * @created 26/07/22 3:12 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork1 {
    /**
     * Problem Description
     *
     * You are given a positive integer A. You have to print the sum of all odd numbers in the range [1, A].
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A <= 1000
     *
     *
     *
     * Input Format
     *
     * First and only line contains a single positive integer A.
     *
     *
     *
     * Output Format
     *
     * Print the required sum in a single line.
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  1
     * Input 2:
     *
     *  4
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  4
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  For A = 1, 1 is the only odd number which lies in the range [1, 1].
     * Explanation 2:
     *
     *  For A = 4, Odd numbers 1 and 3 lie in the range [1, 4].
     *  Sum = 1 + 3 = 4.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int i = 1;
        int totalOddSum = 0;
        while(i <= N) {
            totalOddSum = totalOddSum + i;
            i = i + 2;
        }
        System.out.print(totalOddSum);
        input.close();
    }
}
