package com.scaler.core.java_1_beginner.intro_08_one_1DArrays.homework;

import java.util.Scanner;

/**
 * @created 06/08/22 8:25 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework5 {
    /**
     * Q5. Remove that
     *
     * Problem Description
     *
     * Write a program to input N numbers array from user and delete an element from it at specified position X.
     *
     * Problem Constraints
     *
     * 1 <= N <= 100
     *
     * 1 <= A[i] <= 1000
     *
     * 1 <= X <= N
     *
     *
     *
     * Input Format
     * First line is N which means number of elements.
     *
     * Second line contains N space separated integers.
     *
     * Third line is X position which has to be deleted.
     *
     *
     *
     * Output Format
     * N-1 space separated integers of the input array after deleting the element at required position.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * 5
     * 2 3 1 4 2
     * 3
     *
     *
     * Example Output
     * Output 1:
     *
     * 2 3 4 2
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Clearly after removing A[3] = 1, remaining array is 2 3 4 2.
     * **/
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        x = x - 1;
        for (int i = x; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        n = n - 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
