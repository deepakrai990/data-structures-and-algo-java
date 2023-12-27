package com.scaler.core.java_1_beginner.intro_12_strings.homework;

/**
 * @created 18/08/22 2:17 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework5Solution {
    public static void main(String[] args) {

    }

    private static String solve(String A) {
        String res = "";
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            res += (char)(ch - 'A' + 'a');
        }
        return res;
    }
}
