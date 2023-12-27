package com.scaler.core.java_1_beginner.intro_12_strings.homework;

/**
 * @created 18/08/22 2:17 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework5 {
    /**
     * Q5. High to Low - II
     *
     * Problem Description
     *
     * You are given uppercase string (A) and you have to return after converting that in lowercase form.
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
     * First and only argument containing a uppercase string S.
     *
     *
     *
     * Output Format
     *
     * You have to return lowercase form of input string.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * INTERVIEWBIT
     *
     * Input 2:
     *
     * SCALER
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * interviewbit
     *
     * Output 2:
     *
     * scaler
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * Clearly, lowercase of INTERVIEWBIT is interviewbit.
     *
     * Explanation 2:
     *
     * Clearly, lowercase of SCALER is scaler.
     * **/
    public static void main(String[] args) {

    }

    private static String solve(String A) {
        String res = "";
        for(int i = 0; i < A.length(); i++) {
            res += (char) (A.charAt(i) - 'A' + 'a');
        }
        return res;
    }
}
