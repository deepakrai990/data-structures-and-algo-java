package com.scaler.core.java_1_beginner.intro_07_functions.assignments;

import java.util.Scanner;

/**
 * @created 06/08/22 7:55 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Q2. Volume Of Sphere
     *
     * Problem Description
     *
     * You are given a positive integer A denoting the radius of a sphere. You have to calculate the volume of the sphere.
     *
     * Volume of a sphere having radius R is given by (4 * π * R3) / 3.
     *
     * NOTE: Since, the answer can be a real number, you have to return the ceil value of the volume. Ceil value of a real number X is the smallest integer that is greater than or equal to X.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A <= 400
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
     * Return a single integer denoting the ceil value of volume of the sphere.
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
     *  5
     * Output 2:
     *
     *  269
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  Volume of sphere having radius 1 units = 4.19
     *  Ceil value of volume = 5
     * Explanation 2:
     *
     *  Volume of sphere having radius 4 units = 268.08
     *  Ceil value of volume = 269
     * **/
    private static int solve(final int A) {
        double volumeOfTheSphere = (4 * Math.PI * Math.pow(A, 3)) / 3;
        return (int) Math.ceil(volumeOfTheSphere);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int result = solve(A);
        System.out.println(result);
        in.close();
    }

}
