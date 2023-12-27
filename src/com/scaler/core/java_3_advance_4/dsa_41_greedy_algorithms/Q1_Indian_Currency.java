package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import java.util.Arrays;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Indian_Currency {
    /**
     * Question: Indian Currency {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000}
     * Cash: 5548, minimum number of coins/notes to get required cash
     * **/
    private static void findMinimumNotes(int amount) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int n = denominations.length;
        // Sort denominations in descending order
        Arrays.sort(denominations);
        for (int i = 0; i < n / 2; i++) {
            int temp = denominations[i];
            denominations[i] = denominations[n - i - 1];
            denominations[n - i - 1] = temp;
        }
        System.out.println("Minimum number of notes for " + amount + " is:");
        for (int i = 0; i < n; i++) {
            int notes = amount / denominations[i];
            if (notes > 0) {
                System.out.println(denominations[i] + ": " + notes);
                amount = amount % denominations[i];
            }
        }
    }
    public static void main(String[] args) {
        int amount = 5548;
        findMinimumNotes(amount);
    }
}
