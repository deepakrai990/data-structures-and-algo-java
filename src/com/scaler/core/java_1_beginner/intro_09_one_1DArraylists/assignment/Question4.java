package com.scaler.core.java_1_beginner.intro_09_one_1DArraylists.assignment;

import java.util.Arrays;

/**
 * @created 11/08/22 12:07 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Q4. Frequency count
     *
     * Problem Description
     *
     * You are given an integer array A, you have to return an integer array of same size whose ith element is the
     * frequency count of A[i] in array A .
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= len(A) <= 1000
     *
     * 1 <= A[i] <= 100
     *
     *
     *
     * Input Format
     *
     * First argument is an array of integers representing array A.
     *
     *
     *
     * Output Format
     *
     * You have to return an array of integers as per the question.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * A = [1, 2, 5, 1, 5, 1 ]
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * [3, 1, 2, 3, 2, 3]
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * Clearly, In the given array we have 1 three times, 2 one time and 5 two times.
     * **/
    private static int[] solve(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int curr = 0;
            for(int j = 0; j < n; j++){
                if(A[i] == A[j])
                    curr++;
            }
            ans[i] = curr;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 5, 1, 5, 1};
        int[] result = solve(A);
        System.out.println(Arrays.toString(result));
    }
}
