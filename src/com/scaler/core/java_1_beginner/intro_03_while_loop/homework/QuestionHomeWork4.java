package com.scaler.core.java_1_beginner.intro_03_while_loop.homework;

import java.util.Scanner;

/**
 * @created 26/07/22 3:15 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork4 {
    /**
     * Problem Description
     *
     * You are given a positive integer A. You have to print the sum of all even numbers in the range [1, A].
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
     *  0
     * Output 2:
     *
     *  6
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  For A = 1, there are no even number which lies in the range [1, 1].
     * Explanation 2:
     *
     *  For A = 4, Even numbers 2 and 4 lie in the range [1, 4].
     *  Sum = 2 + 4 = 6.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int i = 2;
        int result = 0;
        while(i <= A) {
            result = result + i;
            i = i + 2;
        }
        System.out.print(result);
    }
}
