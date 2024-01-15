package com.scaler.core.java_1_beginner.intro_08_one_1DArrays.assignment;

import java.util.Scanner;

/**
 * @created 06/08/22 8:16 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    /**
     * Q5. Print in Reverse
     *
     * Problem Description
     *
     * Write a program to print the input array A of size N in reverse order where you have to take integer N and further N elements as input from user.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 1000
     *
     * 1 <= A <= 1000
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
     * A single line containing N space separated integers representing elements of the input array in reverse order.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * 5 1 2 3 4 5
     * Input 2:
     *
     * 4 10 50 40 80
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * 5 4 3 2 1
     * Output 2:
     *
     * 80 40 50 10
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        for(int i = N - 1; i >= 0; i--) {
            System.out.print(A[i] + " ");
        }
        in.close();
    }
}
