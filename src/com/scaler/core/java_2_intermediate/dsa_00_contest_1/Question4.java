package com.scaler.core.java_2_intermediate.dsa_00_contest_1;

/**
 * @created 25/09/22 10:54 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    private static int solve(int[] A, int B) {
        int flag = -1;
        int count = 0;

        // Checking if B exist in list
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B) {
                // intializing flag to 1 if B is found
                flag = 1;
                break;
            }
        }
        //if B found in list
        if (flag == 1) {
            //Checking for no. of elements greater than B
            for (int i = 0; i < A.length; i++) {
                if (A[i] > B)
                    count++;
            }
            return count;
        }
        //if B not found in list
        else {
            return flag;
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 3, 1, 5};
        int B = 3;
        int result = solve(A, B);
        System.out.println("Result : " + result);
    }
}
