package com.scaler.core.java_1_beginner.intro_12_strings.assignment;

/**
 * @created 18/08/22 1:56 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Q2. Diverse Characters
     *
     * Problem Description
     *
     * You are given a character string A having length N.
     *
     * The string consists of 2 types of characters:
     *
     * Alphabets : ['a'-'z', 'A'-'Z']
     * Digits: ['0'-'9']
     *
     * You have to tell the count of characters of the maximum occuring character type.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 105
     *
     *
     * Input Format
     *
     * First and only argument is a character string A.
     *
     *
     * Output Format
     *
     * Return an integer.
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  A = "HelloUser1"
     *
     * Input 2:
     *
     *  A = "M1234"
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  9
     *
     * Output 2:
     *
     *  4
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  Count of alphabets = 9(max)
     *  Count of digits = 1
     *
     * Explanation 2:
     *
     *  Count of alphabets = 1
     *  Count of digits = 4(max)
     * **/
    public static void main(String[] args) {

    }

    private static int solve(final String A) {
        int alphabets = 0;
        int digits = 0;
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                alphabets++;
            } else if(ch >= '0' && ch <= '9') {
                digits++;
            }
        }
        return alphabets > digits ? alphabets : digits;
    }
}
