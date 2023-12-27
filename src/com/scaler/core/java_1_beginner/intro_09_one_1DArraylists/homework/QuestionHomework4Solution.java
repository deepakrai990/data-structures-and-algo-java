package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.homework;

import java.util.ArrayList;

/**
 * @created 18/08/22 6:45 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework4Solution {
    private static int solve(ArrayList<Integer> A, int B) {
        int ans = 0, n = A.size();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(A.get(i)+A.get(j) == B)ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
