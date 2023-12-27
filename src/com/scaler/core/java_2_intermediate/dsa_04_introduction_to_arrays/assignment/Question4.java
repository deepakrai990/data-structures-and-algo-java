package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.assignment;

import java.util.Arrays;

/**
 * @created 19/09/22 5:06 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Q4. Reverse the Array
     * <p>
     * Problem Description
     * You are given a constant array A.
     * <p>
     * You are required to return another array which is the reversed form of the input array.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A.size() <= 10000
     * <p>
     * 1 <= A[i] <= 10000
     * <p>
     * <p>
     * <p>
     * Input Format
     * First argument is a constant array A.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return an integer array.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [1,2,3,2,1]
     * Input 2:
     * <p>
     * A = [1,1,10]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * [1,2,3,2,1]
     * Output 2:
     * <p>
     * [10,1,1]
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Reversed form of input array is same as original array
     * Explanation 2:
     * <p>
     * Clearly, Reverse of [1,1,10] is [10,1,1]
     **/
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int[] solve(final int[] A) {
        int[] b = new int[A.length];
        for (int i = A.length - 1; i <= 0; i--) {
            b[i - (A.length - 1)] = A[i];
        }
        return b;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Let N be the size of the input array.
     * First of all, initialize an output array of size equal to N.
     * Then, iterate over the input array given in the function.
     * Inside the loop make output[i] = input[N-i-1], where N is the size of the input array.
     * After that, just return the output array from the function.
     * **/
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int[] solve1(final int[] A) {
        int n = A.length;
        int []ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = A[n - i - 1];
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] results = solve(A);
        System.out.println("Results : " + Arrays.toString(results));
        results = solve1(A);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
