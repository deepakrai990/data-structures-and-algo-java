package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.homework;

/**
 * @created 19/09/22 8:27 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q4_Time_to_equality {
    /**
     * Q4. Time to equality
     *
     * Problem Description
     * Given an integer array A of size N. In one second, you can increase the value of one element by 1.
     *
     * Find the minimum time in seconds to make all elements of the array equal.
     *
     *
     * Problem Constraints
     * 1 <= N <= 1000000
     * 1 <= A[i] <= 1000
     *
     *
     * Input Format
     * First argument is an integer array A.
     *
     *
     * Output Format
     * Return an integer denoting the minimum time to make all elements equal.
     *
     *
     * Example Input
     * A = [2, 4, 1, 3, 2]
     *
     *
     * Example Output
     * 8
     *
     *
     * Example Explanation
     * We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.
     * **/
    private static int solve(int[] A) {
        int n = A.length;
        int val = 0;
        for(int i = 0; i < n; i++){
            val = Math.max(val, A[i]);
        }
        int ans=0;
        for(int i = 0; i < n; i++) {
            ans += val - A[i];
        }
        return ans;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Since we can only increase the element by 1, we should increase all elements up to the maximum element.
     * We can find the maximum element, and for finding the minimum number of moves, we should find the summation
     * of the absolute difference of all
     * elements with the maximum element.
     * **/
    private static int solve1(int[] A) {
        int n=A.length;
        int val=0;
        for(int i=0;i<n;i++)
        {
            val=Math.max(val,A[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=val-A[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {2, 4, 1, 3, 2};
        int result = solve(A);
        System.out.println("result : " + result);
        result = solve1(A);
        System.out.println("result : " + result);
    }
}
