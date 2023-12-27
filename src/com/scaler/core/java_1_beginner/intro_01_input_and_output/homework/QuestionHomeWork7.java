package com.scaler.core.java_1_beginner.intro_01_input_and_output.homework;

import java.util.Scanner;

/**
 * @created 21/07/22 1:32 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork7 {
    /**
     * Problem Description
     *
     * Your friend Rahul plans to visit exotic countries all around the world. Sadly, Rahul's math skills aren't good. He's pretty worried about being scammed by currency exchanges during his trip - and he wants you to make a currency calculator for him. Here are his specifications for the app:
     *
     * Given the value of a single bill and the amount of bills you received, print the total value of the bills.
     *
     * Input Format
     *
     * The first line of the input is an integer N denoting the value of a single bill.
     *
     * The second line of the input is an integer M denoting the number of bills.
     *
     * Output Format
     *
     * Print in a single line denoting the total value of bills.
     *
     * Problem Constraints
     *
     * 1 <= N <= 100
     *
     * 1 <= M <= 100
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // value of a single bill
        int N = input.nextInt();
        // number of bills
        int M = input.nextInt();
        int totalValueOfbills = M * N;
        System.out.print(totalValueOfbills);
    }
}
