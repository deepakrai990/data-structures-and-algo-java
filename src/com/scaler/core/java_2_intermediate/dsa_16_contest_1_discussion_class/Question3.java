package com.scaler.core.java_2_intermediate.dsa_16_contest_1_discussion_class;

import java.util.ArrayList;

/**
 * @created 26/09/22 7:22 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static int solve(ArrayList<Integer> A, int B) {
        int flag = -1;
        int count = 0;
        // Checking if B exist in list
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == B) {
                // intializing flag to 1 if B is found
                flag = 1;
                break;
            }
        }
        //if B found in list
        if (flag == 1) {
            //Checking for no. of elements greater than B
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i) > B)
                    count++;
            }
            return count;
        }
        //if B not found in list
        else {
            return flag;
        }
    }
    /**
     * Explained in Class
     * **/
    private static int solve1(int[] A, int B) {
        boolean isBPresent = false;
        int elementsToRemove = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B) isBPresent = true;
            if (A[i] > B) elementsToRemove++;
        }
        return isBPresent ? elementsToRemove : -1;
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 3, 1, 5};
        int B = 3;
        int result = solve1(A, B);
        System.out.println("Result : " + result);
        int[] A1 = {1, 4, 2};
        int B1 = 3;
        result = solve1(A1, B1);
        System.out.println("Result : " + result);
    }
}
