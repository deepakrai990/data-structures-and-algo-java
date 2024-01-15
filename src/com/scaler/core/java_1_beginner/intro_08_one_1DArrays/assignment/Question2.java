package com.scaler.core.java_1_beginner.intro_08_one_1DArrays.assignment;

import java.util.Scanner;

/**
 * @created 06/08/22 10:33 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Q2. Max and Min of an Array
     *
     * Problem Description
     *
     * Write a program to print maximum and minimum elements of the input array A of size N where you have to take integer N and other N elements as input from the user.
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
     * A single line containing two space separated integers representing maximum and minimum elements of the input array.
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
     * 5 1
     * Output 2:
     *
     * 80 10
     * **/
    public static int[] findMaxAndMin(int[] arr) {
        int[] maxAndMin = new int[2];
        int max = arr[0];
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(max < arr[i])
                max = arr[i];
            if(min > arr[i])
                min = arr[i];
        }
        maxAndMin[0] = max;
        maxAndMin[1] = min;
        return maxAndMin;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        int[] maxAndMin = findMaxAndMin(arr);
        System.out.print(maxAndMin[0] + " " + maxAndMin[1]);
        in.close();
    }
}
