package com.scaler.core.java_1_beginner.intro_07_functions.assignments;

import java.util.Scanner;

/**
 * @created 06/08/22 7:51 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. Area of Circle
     * Problem Description
     *
     * You are given a positive integer A denoting the radius of a circle. You have to calculate the area of the circle.
     *
     * Arae of a circle having radius R is given by (π * R2).
     *
     * NOTE: Since, the answer can be a real number, you have to return the ceil value of the area. Ceil value of a real number X is the smallest integer that is greater than or equal to X.
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
     * First and only argument is an integer A.
     *
     *
     *
     * Output Format
     *
     * Return a single integer denoting the ceil value of area of the circle.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  A = 1
     * Input 2:
     *
     *  A = 4
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  4
     * Output 2:
     *
     *  51
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  Area of circle having radius 1 units = 3.14
     *  Ceil value = 4
     * Explanation 2:
     *
     *  Area of circle having radius 4 units = 50.27
     *  Ceil value of volume = 51
     * **/
    private static int solve(int A) {
        double areaOfCircle = Math.PI * A * A;
        return (int) Math.ceil(areaOfCircle);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int result = solve(A);
        System.out.println(result);
    }
}
