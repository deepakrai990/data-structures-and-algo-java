package com.scaler.core.java_2_intermediate.dsa_02_time_complexity_1;

/**
 * @created 09/09/22 5:01 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_SumOfNaturalNumbers {
    // Function to calculate the sum of the first N natural numbers
    private static int calculateSum(int N) {
        return N * (N + 1) / 2;
    }
    public static void main(String[] args) {
        int N = 10; // Replace this with the value of N you want to calculate

        // Calculate the sum of the first N natural numbers
        int sum = calculateSum(N);

        // Print the result
        System.out.println("The sum of the first " + N + " natural numbers is: " + sum);
    }
}
