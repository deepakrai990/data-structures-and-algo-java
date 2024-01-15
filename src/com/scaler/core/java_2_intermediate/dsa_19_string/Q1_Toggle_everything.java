package com.scaler.core.java_2_intermediate.dsa_19_string;

import java.util.Arrays;

/**
 * @created 06/10/22 11:29 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Toggle_everything {
    /**
     * Problem: Toggle Everything
     * Given a char array A[N].
     * Toggle everything (small to capital and capital to small)
     * **/
    private static char[] toggle(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] = (char) (chars[i] + 32);
            } else {
                chars[i] = (char) (chars[i] - 32);
            }
        }
        return chars;
    }

    /**
     * Without if and else, using bit operator
     * **/
    private static char[] toggle1(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            // chars[i] = (char) (((int) chars[i]) ^ 32);
            chars[i] = (char) (chars[i] ^ (1 << 5));
        }
        return chars;
    }
    public static void toggleCase(char[] A) {
        for (int i = 0; i < A.length; i++) {
            char currentChar = A[i];
            // Check if the character is an alphabet
            if ((currentChar >= 'A' && currentChar <= 'Z') || (currentChar >= 'a' && currentChar <= 'z')) {
                // Toggle the case using ASCII codes
                A[i] = (char) (currentChar ^ 32);
            }
            // If the character is not an alphabet (e.g., punctuation), leave it unchanged
        }
    }

    public static void main(String[] args) {
        char[] chars = {'A', 'n', 'a', 'C', 'o', 'n', 'D', 'a'}; // "AnaConDa".toCharArray();
        System.out.println("Before toggle : " + Arrays.toString(chars));
        char[] results = toggle(chars);
        System.out.println("After toggle  : " + Arrays.toString(results));

        char[] chars1 = {'A', 'n', 'a', 'C', 'o', 'n', 'D', 'a'};
        System.out.println("Before toggle : " + Arrays.toString(chars1));
        results = toggle1(chars1);
        System.out.println("After toggle :  " + Arrays.toString(results));

        // Example char array
        char[] charArray = {'a', 'B', 'c', 'D', 'e', 'F'};
        // Toggle the case of characters using ASCII codes
        System.out.println("Before toggle : " + Arrays.toString(charArray));
        toggleCase(charArray);
        System.out.println("After toggle  : " + Arrays.toString(charArray));
    }


}
