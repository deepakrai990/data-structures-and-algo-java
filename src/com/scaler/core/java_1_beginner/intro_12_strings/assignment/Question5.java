package com.scaler.core.java_1_beginner.intro_12_strings.assignment;

/**
 * @created 18/08/22 2:08 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    /**
     * Q5. Low to High - II
     * Problem Description
     *
     * You are given lowercase string (A) and you have to return after converting that in upercase form.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= S.size() <= 1000
     *
     *
     *
     * Input Format
     *
     * First and only argument containing a lowercase string S.
     *
     *
     *
     * Output Format
     *
     * You have to return uppercase form of input string.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * interviewbit
     *
     * Input 2:
     *
     * scaler
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * INTERVIEWBIT
     *
     * Output 2:
     *
     * SCALER
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * Clearly, uppercase of interviewbit is INTERVIEWBIT.
     *
     * Explanation 2:
     *
     * Clearly, uppercase of scaler is SCALER.
     * **/
    public static void main(String[] args) {

    }

    private static String solve(String A) {
        String res = "";
        for(int i = 0; i < A.length(); i++) {
            res += (char) (A.charAt(i) - 'a' + 'A');
        }
        return res;
    }
}
