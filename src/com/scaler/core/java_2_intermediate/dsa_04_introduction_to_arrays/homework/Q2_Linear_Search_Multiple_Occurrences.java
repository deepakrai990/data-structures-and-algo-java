package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.homework;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @created 19/09/22 8:13 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Linear_Search_Multiple_Occurrences {
    /**
     * Q2. Linear Search - Multiple Occurences
     *
     * Problem Description
     * Given an array A and an integer B, find the number of occurrences of B in A.
     *
     *
     * Problem Constraints
     * 1 <= B, Ai <= 109
     * 1 <= |A| <= 105
     *
     *
     * Input Format
     * Given an integer array A and an integer B.
     *
     *
     * Output Format
     * Return an integer, number of occurrences of B in A.
     *
     *
     * Example Input
     * Input 1:
     *  A = [1, 2, 2], B = 2
     * Input 2:
     *  A = [1, 2, 1], B = 3
     *
     *
     * Example Output
     * Output 1:
     *  2
     * Output 2:
     *  0
     *
     *
     * Example Explanation
     * Explanation 1:
     * Element at index 2, 3 is equal to 2 hence count is 2.
     * Explanation 2:
     * There is no element equal to 3 in the array.
     * **/
    private static int solve(int[] A, int B) {
        int res = 0;
        for (int i = 0; i < A.length; i++)
            if (B == A[i])
                res++;
        return res;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * **/
    private static int solve1(ArrayList<Integer> A, int B) {
        int ans = 0;
        for(int i = 0; i < A.size(); ++i){
            if(A.get(i) == B){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 2};
        int B = 2;
        int result = solve(A, B);
        System.out.println("result : " + result);
        result = solve1(new ArrayList(Arrays.asList(A)), B);
        System.out.println("result : " + result);
    }
}
