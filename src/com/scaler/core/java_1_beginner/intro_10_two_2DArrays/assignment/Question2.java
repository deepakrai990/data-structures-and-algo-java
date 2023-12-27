package com.scaler.core.java_1_beginner.intro_10_two_2DArrays.assignment;

import java.util.Scanner;

/**
 * @created 18/08/22 6:51 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Q2. Wave Print (Row Wise)
     *
     * Problem Description
     *
     * Write a program to input an integer N and a N*N matrix Mat from user and print the matrix in wave form (row wise)
     *
     * See example for clarifications regarding wave print.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 103
     *
     * 0 <= Mat[i][j] <= 109
     *
     *
     *
     * Input Format
     *
     * First line is an integer N
     *
     * Next N lines contain N space separated integers representing the matrix Mat
     *
     *
     *
     * Output Format
     *
     * A single line containing N*N integers of matrix Mat in wave form (row wise)
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * 3
     * 4 1 2
     * 7 4 4
     * 3 7 4
     *
     * Input 2:
     *
     * 2
     * 1 2
     * 3 4
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * 4 1 2 4 4 7 3 7 4
     *
     * Output 2:
     *
     * 1 2 4 3
     *
     *
     *
     * Example Explanation
     * For Input 1:
     *
     * We will first iterate the 1st row from left to right and print the elements,
     * then we will iterate the 2nd row from right to left and print the elements,
     * then we will iterate the 3rd row from left to right and print the elements.
     * This looks like a wave.
     *
     * For Input 2:
     *
     * We will first iterate the 1st row from left to right and print the elements,
     * then we will iterate the 2nd row from right to left and print the elements.
     * This looks like a wave.
     * **/
    private static void printWaveForm_RowWise(int[][] mat) {
        for(int c = 0 ; c < mat.length; c++) {
            if(c % 2 == 0) {
                for(int r = 0; r < mat[0].length; r++) {
                    System.out.print(mat[c][r] + " ");
                }
            } else {
                for(int r = mat[0].length - 1; r >= 0; r--) {
                    System.out.print(mat[c][r] + " ");
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = rows;
        int[][] mat = new int[rows][cols];
        for(int r = 0; r < mat.length; r++) {
            for(int c = 0; c < mat[r].length; c++) {
                mat[r][c] = scn.nextInt();
            }
        }
        printWaveForm_RowWise(mat);
    }
}
