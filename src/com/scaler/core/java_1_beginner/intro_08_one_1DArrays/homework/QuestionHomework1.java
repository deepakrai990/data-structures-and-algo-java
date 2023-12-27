package com.scaler.core.java_1_beginner.intro_08_one_1DArrays.homework;

import java.util.Scanner;

/**
 * @created 06/08/22 8:25 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1 {
    /**
     * Problem Description
     *
     * Write a program to print all negative numbers from input array A of size N where you have to take integer N and further N elements as input from user.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 1000
     *
     *
     *
     * -1000 <= A <= 1000
     *
     *
     *
     * Input Format
     *
     * A single line representing N followed by N integers of the array A
     *
     *
     *
     * Output Format
     *
     * A single line containing elements from the input array which are negative in the same order.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * 5 1 -5 2 -8 -4
     * Input 2:
     *
     * 4 -1 0 -8 -1
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * -5 -8 -4
     * Output 2:
     *
     * -1 -8 -1
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        for(int i = 0; i < N; i++) {
            if(A[i] < 0) {
                System.out.print(A[i] + " ");
            }
        }
    }
}
