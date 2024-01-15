package com.scaler.core.java_1_beginner.intro_08_one_1DArrays.assignment;

import java.util.Scanner;

/**
 * @created 06/08/22 8:08 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. Insert that
     *
     * Problem Description
     * Write a program to input N numbers array from user and insert an element Y in it at specified position X.
     * Note: When an element is inserted at position X, all elements that were already present at position >= X, gets shifted to one position right.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 100
     *
     * 1 <= A[i] <= 1000
     *
     * 1 <= X <= N
     *
     * 1 <= Y <= 1000
     *
     *
     *
     * Input Format
     * First line is N which means number of elements.
     *
     * Second line contains N space separated integers.
     *
     * Third line is X position where Y has to be inserted.
     *
     * Fourth line is Y which has to be inserted.
     *
     *
     *
     * Output Format
     * N+1 space separated integers of the input array after inserting the element at required position.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * 5
     * 2 3 1 4 2
     * 3
     * 5
     *
     *
     * Example Output
     * Output 1:
     *
     * 2 3 5 1 4 2
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Clearly after inserting 5 at 3rd position, new array is 2 3 5 1 4 2.
     * **/
    public static int[] insertNewElementAtXPosition(int N, int x, int y, int[] arrOne) {
        int[] arrTwo = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            if(i < x - 1) {
                arrTwo[i] = arrOne[i];
            } else if(i == (x - 1)) {
                arrTwo[i] = y;
            } else {
                arrTwo[i] = arrOne[i - 1];
            }
        }
        return arrTwo;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arrOne = new int[N];

        for(int i = 0; i < N; i++) {
            arrOne[i] = in.nextInt();
        }
        int x = in.nextInt();
        int y = in.nextInt();
        int[] arrNew = insertNewElementAtXPosition(N, x, y, arrOne);

        for(int i = 0; i < N + 1; i++) {
            System.out.print(arrNew[i] + " ");
        }
        in.close();
    }
}
