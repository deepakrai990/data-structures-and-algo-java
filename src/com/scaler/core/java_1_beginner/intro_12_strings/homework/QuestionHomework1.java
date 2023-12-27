package com.scaler.core.java_1_beginner.intro_12_strings.homework;

/**
 * @created 18/08/22 1:53 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1 {
    /**
     * Q1. Beesly String
     *
     * Problem Description
     * Mr. Jim likes playing with strings a lot, so Mrs. Pam gifted him a string A which has some very unique magical
     * powers.
     * The string consists of lowercase latin letters 'p','a' and 'm' only.
     *
     * In one wish, Mr Jim can perform one of the following operations:
     *
     *     Remove exactly one occurrence of 'p' and exactly one occurrence of 'm', from anywhere inside string A.
     *     Remove exactly one occurrence of 'a' and exactly one occurrence of 'm', from anywhere inside string A.
     *
     * Now Mr. Jim wants to know if after some number of wishes is it possible to make string A empty.
     *
     * Return 1 if it is possible to make string A empty after some number of operations otherwise Return 0.
     *
     *
     *
     * Problem Constraints
     * 1 ≤ |A| ≤ 105
     *
     *
     *
     * Input Format
     *
     * The first argument is a string, A.
     *
     *
     *
     * Output Format
     *
     * Return 1, if it is possible to make string A empty. Otherwise return 0.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * A = "mpampamm"
     *
     * A = "pampampam"
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  1
     *
     *  0
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * We can reduce the string to null in the following sequence of steps:
     * 1) mpampamm : initial state
     * 2) mampam   : removing 2nd and 8th character
     * 3) mpam     : removing 1st and 2nd character
     * 4) am       : removing 1st and 2nd character
     * 5)          : removing 1st and 2nd character
     * So the answer is 1.
     *
     * Explanation 2:
     *
     * It is not possible to empty the string using any sequence of steps.
     * **/
    public static void main(String[] args) {

    }
    private static int solve(String A) {
        int mCount = 0;
        int pCount = 0;
        int aCount = 0;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == 'm') {
                mCount++;
            } else if(A.charAt(i) == 'p') {
                pCount++;
            } else if(A.charAt(i) == 'a') {
                aCount++;
            }
        }
        if((pCount == 0) && (aCount == mCount) || (aCount == 0) && (pCount == mCount)) {
            return 1;
        } else if((pCount + aCount) == mCount) {
            return 1;
        } else {
            return 0;
        }
    }
}
