package com.scaler.core.java_2_intermediate.dsa_19_string;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q7_Reverse_whole_string {
    /**
     * Problem: Given a String, reverse whole string
     * **/
    // Function to reverse the whole string
    private static String reverseWholeString(String s) {
        // Step 1: Convert the string to a char array
        char[] charArray = s.toCharArray();
        // Step 2: Use two pointers to swap characters from start and end
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
        // Step 3: Convert the char array back to a string
        return new String(charArray);
    }
    public static void main(String[] args) {
        // Example input
        String s = "I have love dsa";
        System.out.println("Original Words: " + s);
        // Reverse the whole string
        String result = reverseWholeString(s);
        // Print the result
        System.out.println("Reversed Whole String: " + result);
    }
}
