package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.homework;

import java.util.Scanner;

/**
 * @created 23/07/22 2:03 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork1 {
    /**
     * Problem Description
     * Given two numbers A and B. Print the floor of A/B.
     *
     *
     * Problem Constraints
     * 1 <= A, B <= 104
     *
     *
     * Input Format
     * There are two input lines
     * The first line has a single integer A.
     * The second line has a single integer B.
     *
     *
     * Output Format
     * Print in a single line the floor of A/B.
     *
     *
     * Example Input
     * Input 1:-
     * 4
     * 5
     * Input 2:-
     * 16
     * 2
     *
     *
     * Example Output
     * Output 1:-
     * 0
     * Output 2:-
     * 8
     *
     *
     * Example Explanation
     * Explanation 1:-
     * floor(4/5) = 0
     * Explanation 2:-
     * floor(16/2) = 8
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        System.out.print(A / B);
    }
}
