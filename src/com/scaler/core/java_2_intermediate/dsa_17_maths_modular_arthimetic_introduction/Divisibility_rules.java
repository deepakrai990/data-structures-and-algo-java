package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class Divisibility_rules {
    /**
     * 1. Divisibility by 2:
     * A number is divisible by 2 if its last digit is even (0, 2, 4, 6, 8).
     * **/
    private static boolean isDivisibleBy2(int number) {
        return (number % 2 == 0);
    }
    /**
     * 2. Divisibility by 3:
     * A number is divisible by 3 if the sum of its digits is divisible by 3.
     * **/
    private static boolean isDivisibleBy3(int number) {
        int sum = calculateSumOfDigits(number);
        return (sum % 3 == 0);
    }
    private static int calculateSumOfDigits(int num) {
        int sum = 0;
        // Iterate through each digit
        while (num > 0) {
            sum += num % 10;  // Add the last digit to the sum
            num /= 10;        // Remove the last digit
        }
        return sum;
    }
    /**
     * 3. Divisibility by 4:
     * A number is divisible by 4 if the last two digits form a number divisible by 4.
     * **/
    private static boolean isDivisibleBy4(int number) {
        return ((number % 100) % 4 == 0);
    }
    /**
     * 4. Divisibility by 5:
     * A number is divisible by 5 if its last digit is either 0 or 5.
     * **/
    private static boolean isDivisibleBy5(int number) {
        return (number % 10 == 0 || number % 10 == 5);
    }
    /**
     * 5. Divisibility by 6:
     * A number is divisible by 6 if it is divisible by both 2 and 3.
     * **/
    private static boolean isDivisibleBy6(int number) {
        return isDivisibleBy2(number) && isDivisibleBy3(number);
    }
    /**
     * 6. Divisibility by 9:
     * A number is divisible by 9 if the sum of its digits is divisible by 9.
     * **/
    private static boolean isDivisibleBy9(int number) {
        int sum = calculateSumOfDigits(number);
        return (sum % 9 == 0);
    }
    /**
     * 7. Divisibility by 10:
     * A number is divisible by 10 if it ends in 0.
     * **/
    private static boolean isDivisibleBy10(int number) {
        return (number % 10 == 0);
    }

    public static void main(String[] args) {
        int numberFor2 = 348;
        boolean result = isDivisibleBy2(numberFor2);
        System.out.println("Is " + numberFor2 + " divisible by 2 : " + result);

        int numberFor3 = 567;
        result = isDivisibleBy3(numberFor3);
        System.out.println("Is " + numberFor3 + " divisible by 2 : " + result);
    }
}
