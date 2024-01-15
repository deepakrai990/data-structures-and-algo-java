package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction;

/**
 * @created 28/09/22 2:48 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Not_Divisible_by_3 {
    // Function to check divisibility by 3
    public static boolean isDivisibleBy3(int number) {
        // Calculate the sum of digits
        int sum = calculateSumOfDigits(number);
        // Check if the sum is divisible by 3
        return (sum % 3 == 0);
    }

    // Function to calculate the sum of digits
    public static int calculateSumOfDigits(int num) {
        int sum = 0;
        // Iterate through each digit
        while (num > 0) {
            sum += num % 10;  // Add the last digit to the sum
            num /= 10;        // Remove the last digit
        }
        return sum;
    }
    public static void main(String[] args) {
        int exampleNumber = 567;
        // Check divisibility by 3
        boolean result = isDivisibleBy3(exampleNumber);
        // Print the result
        System.out.println("Is " + exampleNumber + " divisible by 3 : " + result);
    }
}
