package com.scaler.core.java_2_intermediate.dsa_07_arrays_subarrays.homework;

/**
 * @created 09/09/22 11:59 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int solve(int[] A, int B) {
        int size = 0, sum = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            size = 0;
            sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                size++;
                if (sum < B && size % 2 == 0) count++;
                else if (sum > B && size % 2 != 0) count++;
            }
        }
        return count;
    }
    /**
     * Scaler Solution
     *
     * Hint 1
     * The constraints are small.
     * Have you tried doing just what the question says?
     *
     * Solution Approach
     * The constraints are small.
     * Have you tried doing just what the question says?
     * Since the constraints are small we can generate all subarrays using 2 loops. This can be done in O(N^2).
     * Then find the sum of each subarray and check both the conditions.
     * Note that we cannot iterate over the subarray after generating the left index and right index to
     * find the sum as this will increase the time complexity of the solution to O(N^3).
     * We can find the sum of each subarray in O(1) with the help of a prefix sum array,
     * which takes an O(N) precomputation.
     * Please refer to the complete solution for implementation.
     * **/
    private static int solve1(int[] A, int B) {
        int n = A.length;
        int pref[] = new int[n];
        pref[0] = A[0];
        int ans = 0;
        for(int i = 1 ; i < n ; i++){
            pref[i] = pref[i - 1] + A[i];
        }
        for(int i = 0 ; i < n ; i++){
            for (int j = i ; j < n ; j++){
                int sz = j - i + 1;
                int sum;
                if(i == 0){
                    sum = pref[j];
                } else{
                    sum = pref[j] - pref[i - 1];
                }
                if(sz % 2 == 0 && sum < B) ans++;
                if(sz % 2 == 1 && sum > B) ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        int B = 65;
        int result = solve(A, B);
        System.out.println("Result : " + result);
        result = solve1(A, B);
        System.out.println("Result : " + result);
    }
}
