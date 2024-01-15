package com.scaler.core.java_2_intermediate.dsa_19_string;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q5_Reverse_the_words {
    /**
     * Problem: Given a String, reverse the words
     * **/
    // Function to reverse the words in a string
    private static String reverseWords(String s) {
        // Step 1: Split the input string into individual words
        String[] words = s.split(" ");
        // Step 2: Reverse the order of the words
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            // Swap the words at left and right positions
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            // Move pointers towards the center
            left++;
            right--;
        }
        // Step 3: Join the reversed words to form the final reversed string
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }
        // Remove the trailing space and return the result
        return result.toString().trim();
    }

    public static void main(String[] args) {
        // Example input
        String s = "I have love dsa";
        System.out.println("Original Words: " + s);
        // Reverse the words in the string
        String result = reverseWords(s);
        // Print the result
        System.out.println("Reversed Words: " + result);
    }
}
