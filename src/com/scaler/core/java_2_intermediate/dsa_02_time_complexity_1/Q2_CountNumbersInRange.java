package com.scaler.core.java_2_intermediate.dsa_02_time_complexity_1;

/**
 * @author Deepak Kumar Rai
 * @created 30/12/23
 * @project scaler_course_code
 */
public class Q2_CountNumbersInRange {
    /**
     * Ranges-------calculation
     * [a b]------- b - a + 1
     * [a b)------- (b - 1) - a + 1 = b - a
     * (a b]------- b - (a - 1) + 1 = b - a
     * (a b)------- (b - 1) - (a - 1) + 1 = b - a - 1
     * **/
    // Function to calculate the count of numbers in a range [a, b]
    private static int calculateCountInRange(int a, int b) {
        return b - a + 1;
    }
    public static void main(String[] args) {
        int start = 3; // Start of the range
        int end = 10; // End of the range

        // Calculate the count of numbers in the range [3, 10]
        int count = calculateCountInRange(start, end);

        // Print the result
        System.out.println("The count of numbers in the range [" + start + ", " + end + "] is: " + count);
    }
}
