package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.homework;

/**
 * @created 18/08/22 6:46 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework5 {
    /**
     * Q5. Consecutive Duplicate
     *
     * Problem Description:
     *
     * Write a function to check if the input list has consecutive duplicate elements or not.
     * Return True if there are consecutive duplicate elements in the list else return False.
     *
     * Input Format:
     *
     * An integer array A as the function argument.
     *
     * Output Format:
     *
     * Return True or False
     *
     * Sample Input:
     *
     * A = [1, 2, 3, 3]
     *
     * Sample Output:
     *
     * True
     *
     * Sample Explanation:
     *
     * As there are 3 3 in the list i.e. at indices 2 and 3, there True is returned.
     * **/
    private static boolean solve(int arr[]) {
        // Complete the function here
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            if(arr[j] == arr[i]) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
