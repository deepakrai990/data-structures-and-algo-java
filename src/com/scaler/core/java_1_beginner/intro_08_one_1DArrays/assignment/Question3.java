package com.scaler.core.java_1_beginner.intro_08_one_1DArrays.assignment;

import java.util.Scanner;

/**
 * @created 06/08/22 8:10 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Sum the Array
     *
     * Problem Description
     * Write a program to print sum of elements of the input array A of size N where you have to take integer N and further N elements as input from user.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 1000
     *
     * 1 <= A <= 1000
     *
     *
     *
     * Input Format
     * A single line representing N followed by N integers of the array A
     *
     *
     *
     * Output Format
     * A single integer containing sum of elements from the input array.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * 5 1 2 3 4 5
     * Input 2:
     *
     * 4 10 50 40 80
     *
     *
     * Example Output
     * Output 1:
     *
     * 15
     * Output 2:
     *
     * 180
     * **/
    public static int sumOfArray(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        int result = sumOfArray(arr);
        System.out.print(result);
        in.close();
    }
}
