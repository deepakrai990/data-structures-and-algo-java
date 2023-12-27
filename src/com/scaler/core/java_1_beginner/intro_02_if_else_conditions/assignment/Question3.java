package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.assignment;

import java.util.Scanner;

/**
 * @created 23/07/22 1:21 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Problem Description:
     *
     * Write a program to calculate the percentage and grades according to the percentage of a student. Five numbers(A, B, C, D & E) represent the marks of a student in 5 subjects which are out of 100. Print the percentage and the grade of the student.
     *
     * If percentage >= 90% : Grade A
     * If percentage >= 80% but <90 : Grade B
     * If percentage >= 70% but <80: Grade C
     * If percentage >= 60% but <70: Grade D
     * If percentage >= 40% but <60: Grade E
     * If percentage < 40%: Grade F
     * NOTE: You have to take the lowest integer of the percentage. E.g. 90.8% will be treated as 90%.
     *
     * Input Format:
     *
     * There will be five lines of inputs as following:
     *
     * The five lines contain the 5 subject marks of the student in numerical format.
     * Output Format:
     *
     * The first line indicates the percentage in integer format.
     *
     * The next line displays the grade in string format.
     * Sample Input:
     *
     * 50
     * 60
     * 70
     * 80
     * 90
     * Sample Output:
     *
     * 70
     * C
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();
        int D = input.nextInt();
        int E = input.nextInt();
        float total = A + B + C + D + E;
        int percentage = (int) ((total / 500f) * 100f);
        String grade = "";
        if(percentage < 40) {
            grade = "F";
        } else if(percentage < 60) {
            grade = "E";
        } else if(percentage < 70) {
            grade = "D";
        } else if(percentage < 80) {
            grade = "C";
        } else if(percentage < 90) {
            grade = "B";
        } else {
            grade = "A";
        }
        System.out.println(percentage);
        System.out.println(grade);
    }
}
