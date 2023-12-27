package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.homework;

/**
 * @created 18/08/22 6:44 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework3Solution {
    private static int solve(int[] A) {
        int index = 0, n = A.length;
        for(int i = 1; i < n; i++){
            if(A[i] > A[index]){
                index = i;
            }
        }

        int ans = -1;
        for(int i = 0; i < n; i++){
            if(i != index){
                ans = Math.max(ans, A[i]);
            }
        }

        return ans;
    }
    public static void main(String[] args) {

    }
}
