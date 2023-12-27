package com.scaler.core.java_1_beginner.intro_12_strings.homework;

/**
 * @created 18/08/22 2:11 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework2Solution {
    public static void main(String[] args) {

    }

    private static String solve(String A) {
        String ans = "";
        for (int i = 0; i < A.length(); i++) {
            ans = ans + A.charAt(i) + Integer.toString((int) A.charAt(i) - (int) 'a' + 1);
        }
        return ans;
    }
}
