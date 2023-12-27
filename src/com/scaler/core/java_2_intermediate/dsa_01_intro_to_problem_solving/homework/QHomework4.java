package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.homework;

/**
 * @created 19/09/22 4:09 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    /**
     * Q4. Make it
     *
     * Given two integers A and B. A represents the count of mangoes and B represent the count of slices of mangoes.
     * Mango can be cut into three slices of mangoes. A glass of mango shake can be formed by two slices of mangoes.
     *
     * Find the maximum number of glasses of mango shakes you can make with A mangoes and B slices
     * of mangoes initially.
     *
     *
     * Input Format
     *
     * The First argument is an integer A.
     * The Second argument is an integer B.
     * Output Format
     *
     * Return the maximum number of glasses of mango shakes you can make.
     * Constraints
     *
     * 0 <= A, B <= 10^8
     * For Example
     *
     * Input 1:
     *     A = 19
     *     B = 0
     * Output 1:
     *     28
     *
     * Input 2:
     *     A = 7
     *     B = 1
     * Output 2:
     *     11
     * **/
    private static int solve(int A, int B) {
        int numberOfGlassesOfMangoShakes = 0;
        int totalSlices = (A * 3) + B;
        numberOfGlassesOfMangoShakes = totalSlices / 2;
        return numberOfGlassesOfMangoShakes;
    }
    /**
     * Scaler Solution
     * Approach
     * A mangoes will give 3*A mango slices and total mango slices will became B+3*A;
     * answer if integer division of (B+3*A)/2
     * **/
    private static int solve1(int A, int B) {
        return (B+A+A+A)/2;
    }
    public static void main(String[] args) {
        int A = 19;
        int B = 0;
        int result = solve(A, B);
        System.out.println("Result : " + result);
        result = solve1(A, B);
        System.out.println("Result : " + result);
    }
}
