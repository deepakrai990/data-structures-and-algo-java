package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.assignment;

import java.util.ArrayList;

/**
 * @created 18/08/22 6:34 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Q2. Divisible by 5 and 7
     *
     * Problem Description:
     *
     * Write a program that returns the list of elements that are present in the given list and are divisible by 5 and 7.
     *
     * Input Format:
     *
     * The only argument is the given list of elements
     *
     * Output Format:
     *
     * Return a list consisiting of the elements that are divisible by 5 and 7 from the given list.
     *
     * Sample Input:
     *
     * [23, 34, 25, 35, 66, 70, 14]
     *
     * Sample Output:
     *
     * [35, 70]
     *
     * Sample explanation:
     *
     * Only 35 and 70 are divisible by 5 and 7 from the list [23,34,25,35,66,70,14]
     * therefore the list consisting of only these two elements is returned.
     * **/
    private static ArrayList<Integer> solve(ArrayList<Integer> arr) {
        // Complete function template here
        ArrayList<Integer> list = new ArrayList<>();
        for(int element: arr) {
            if((element % 5 == 0) && (element % 7 == 0)) {
                list.add(element);
            }
        }
        return list;
    }
    public static void main(String[] args) {

    }
}
