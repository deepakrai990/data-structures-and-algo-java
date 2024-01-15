package com.scaler.core.java_2_intermediate.dsa_19_string;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q6_Reverse_each_word {
    /**
     * Problem: Given a String, reverse each word
     * **/
    // Function to reverse each word in a string
    private static String reverseEachWord(String s) {
        // Step 1: Split the input string into individual words
        String[] words = s.split(" ");
        // Step 2: Reverse each word separately
        for (int i = 0; i < words.length; i++) {
            words[i] = reverseString(words[i]);
        }
        // Step 3: Join the reversed words to form the final reversed string
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }
        // Remove the trailing space and return the result
        return result.toString().trim();
    }
    // Helper function to reverse a string
    private static String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            // Swap characters at left and right positions
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            // Move pointers towards the center
            left++;
            right--;
        }
        // Convert the char array back to a string
        return new String(charArray);
    }
    public static void main(String[] args) {
        // Example input
        String s = "I have love dsa";
        System.out.println("Original Words: " + s);
        // Reverse each word in the string
        String result = reverseEachWord(s);
        // Print the result
        System.out.println("Reversed Each Word: " + result);
    }
}
