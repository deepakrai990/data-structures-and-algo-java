package com.scaler.core.java_1_beginner.intro_10_two_2DArrays.assignment;

import java.util.Scanner;

/**
 * @created 18/08/22 6:50 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. Wave Print (Column Wise)
     *
     * Problem Description
     *
     * Write a program to input an integer N and a N*N matrix Mat from user and print the matrix in wave
     * form (column wise)
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
     * A single line containing N*N integers of matrix Mat in wave form (column wise)
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
     * 4 7 3 7 4 1 2 4 4
     *
     * Output 2:
     *
     * 1 3 4 2
     *
     *
     *
     * Example Explanation
     * For Input 1:
     *
     * We will first iterate the 1st column from top to botton and print the elements,
     * then we will iterate the 2nd column from botton to top and print the elements,
     * then we will iterate the 3rd column from top to botton and print the elements.
     *
     * For Input 2:
     *
     * We will first iterate the 1st column from top to botton and print the elements,
     * then we will iterate the 2nd column from botton to top and print the elements.
     * **/
    private static void printWaveForm_ColumnWise(int[][] mat) {
        for(int c = 0 ; c < mat[0].length; c++) {
            if(c % 2 == 0) {
                for(int r = 0; r < mat.length; r++) {
                    System.out.print(mat[r][c] + " ");
                }
            } else {
                for(int r = mat.length - 1; r >= 0; r--) {
                    System.out.print(mat[r][c] + " ");
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
        printWaveForm_ColumnWise(mat);
        scn.close();
    }
}
