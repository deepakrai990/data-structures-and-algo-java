package com.scaler.core.java_1_beginner.intro_12_strings.homework;

/**
 * @created 18/08/22 2:11 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework2 {
    /**
     * Q2. Char Index
     *
     * Problem Description
     *
     * Shivam has a string A of size N containing only lowercase characters. He will update the string by inserting a number after every char which will be the index of that char.
     *
     * For E.g.: if string is azd then it will be updated as a1z26d4 since index of a is 1, of z is 26 and of d is 4.
     *
     * You have to tell how the string will look like afterwards,
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A.size() <= 1000
     *
     * a <= A[i] <= z
     *
     *
     *
     * Input Format
     *
     * First argument is string A.
     *
     *
     *
     * Output Format
     *
     * You have to return an string as per the question.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * scaler
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * s19c3a1l12e5r18
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * Clearly after putting all the chars index in "scaler" it will become "s19c3a1l12e5r18".
     * **/
    public static void main(String[] args) {

    }

    private static String solve(String A) {
        String result = "";
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            int alphabeticalIndex = (int) ch - (int) 'a' + 1;
            result = (result + ch) + alphabeticalIndex;
        }
        return result;
    }
}
