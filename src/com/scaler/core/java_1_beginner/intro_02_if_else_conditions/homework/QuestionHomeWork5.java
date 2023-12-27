package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.homework;

import java.util.Scanner;

/**
 * @created 23/07/22 2:58 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork5 {
    /**
     * Problem Description
     *
     * You are given 3 integer angles(in degrees) A, B and C of a triangle. You have to tell whether the triangle is valid or not.
     *
     * A triangle is valid if sum of its angles equals to 180.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A, B, C <= 180
     *
     *
     *
     * Input Format
     *
     * First line of the input contains an integer A.
     *
     * Second line of the input contains an integer B.
     *
     * Third line of the input contains an integer C.
     *
     *
     *
     * Output Format
     *
     * Print 1 if the triangle having given sides is valid, else print 0.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  60
     *  60
     *  60
     * Input 2:
     *
     *  30
     *  40
     *  50
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  0
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  Sum of angles = A + B + C = 60 + 60 + 60 = 180
     *  Hence, the given triangle is valid.
     * Explanation 2:
     *
     *  Sum of angles = A + B + C = 30 + 40 + 50 = 120
     *  As sum of angles is not equal to 180, the given triangle is not valid.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();
        int total = A + B + C;
        if (total == 180) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
