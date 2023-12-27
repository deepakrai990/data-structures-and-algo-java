package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.homework;

import java.util.Scanner;

/**
 * @created 23/07/22 3:26 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork9 {
    /**
     * Problem Description
     *
     * Write a program to input from user three numbers(A, B & C) representing side lengths of a triangle.
     *
     * You have to print if the traingle is "equilateral", "scalene" or "isosceles".
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A <= 100000
     *
     * 1 <= B <= 100000
     *
     * 1 <= C <= 100000
     *
     *
     *
     * Input Format
     *
     * One line containing three space separated integers A, B & C.
     *
     *
     *
     * Output Format
     *
     * One string either "equilateral", "scalene" or "isosceles".
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * 5 6 7
     * Input 2:
     *
     * 30 30 30
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * scalene
     * Output 2:
     *
     * equilateral
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * Since all sides are different, hence it's a scalene triangle.
     * Explanation 2:
     *
     * Since all sides are same, hence it's a equilateral triangle.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();
        if (A == B && B == C) {
            System.out.print("equilateral");
        } else if (A == B || B == C || C == A) {
            System.out.print("isosceles");
        } else {
            System.out.print("scalene");
        }
    }
}
