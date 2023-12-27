package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.homework;

/**
 * @created 18/08/22 6:46 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework5Solution {
    public boolean solve(int[] arr) {
        boolean ans = false;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                ans = true;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
