package com.scaler.core.java_1_beginner.intro_11_two_2DArraylists.homework;

import java.util.ArrayList;

/**
 * @created 18/08/22 6:24 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1Solution {
    public static void main(String[] args) {

    }

    private static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer>ans = new ArrayList<>();
        int n = A.size();
        int m = A.get(0).size();

        //travel rows to get each row sum
        for(int i=0; i < n; i++) {
            int temp = 0;
            for(int j=0; j < m;j++) {
                temp += A.get(i).get(j);
            }
            ans.add(temp);
        }

        //travel cols to get each col sum
        for(int j=0; j < m; j++) {
            int temp = 0;
            for(int i=0; i < n;i++) {
                temp += A.get(i).get(j);
            }
            ans.add(temp);
        }

        return ans;
    }
}
