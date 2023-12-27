package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.homework;

/**
 * @created 09/08/22 11:05 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework3 {
    /**
     * Q3. Second Largest
     *
     * Problem Description
     *
     * You are given an integer array A. You have to find the second largest element/value in the array or report
     * that no such element exists.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= |A| <= 105
     *
     * 0 <= A[i] <= 109
     *
     *
     *
     * Input Format
     *
     * The first argument is an integer array A.
     *
     *
     *
     * Output Format
     *
     * Return the second largest element. If no such element exist then return -1.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  A = [2, 1, 2]
     *
     * Input 2:
     *
     *  A = [2]
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  2
     *
     * Output 2:
     *
     *  -1
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  First largest element = 2
     *  Second largest element = 2
     *  Third largest element = 1
     *
     * Explanation 2:
     *
     *  There is no second largest element in the array.
     * **/
    private static int solve(int[] array) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = -1;
        if (array.length < 2)
            return secondHighest;
        for (int i = 0; i < array.length; i++) {

            if (array[i] > highest) {
                secondHighest = highest;
                highest = array[i];
            } else if (array[i] > secondHighest) {
                secondHighest = array[i];
            }
        }
        return secondHighest;
    }
    public static void main(String[] args) {
        int[] array = {435581990};
        int result = solve(array);
        System.out.println(result);

    }
}
