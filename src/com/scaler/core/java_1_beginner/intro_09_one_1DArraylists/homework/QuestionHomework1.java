package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.homework;

/**
 * @created 18/08/22 6:40 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1 {
    /**
     * Q1. Product of elements
     *
     * Problem Description:
     *
     * Write a program that returns the product of all elements present in the list.
     *
     * Constraints:
     *
     * 1 <= |A| <= 100
     * 1 <= A <= 100
     * Note: It is guaranteed that the resultant product will be <= 1015
     *
     * Input Format:
     *
     * An integer array A as the function argument.
     *
     * Output Format:
     *
     * Product of elements in integer format
     *
     * Sample Input:
     *
     * A = [7, 9, 2, 51]
     *
     * Sample Output:
     *
     * 6426
     *
     * Sample explanation:
     *
     * The product of all the elements is 7 * 9 * 2 * 51 = 6426 is returned.
     * **/
    private static long solve(int arr[]) {
        // Complete the function template here
        long product = arr[0];
        for(int i = 1; i < arr.length; i++) {
            product *= arr[i];
        }
        return product;
    }

    public static void main(String[] args) {

    }
}
