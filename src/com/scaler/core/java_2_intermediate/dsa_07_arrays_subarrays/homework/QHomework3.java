package com.scaler.core.java_2_intermediate.dsa_07_arrays_subarrays.homework;

/**
 * @created 25/09/22 8:26 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int solve(int[] A, int B) {
        int n = A.length;
        int start = 0, end = 0;
        int count = 0, sum = A[0];
        while (start < n && end < n) {
            // If sum is less than B,
            // move end by one position.
            // Update count and sum
            // accordingly.
            if (sum < B) {
                end++;
                if (end >= start)
                    count += end - start;
                // For last element,
                // end may become n.
                if (end < n)
                    sum += A[end];
            }
            // If sum is greater than or
            // equal to B, subtract
            // A[start] from sum and
            // decrease sliding window by
            // moving start by one position
            else {
                sum -= A[start];
                start++;
            }
        }
        return count;
    }
    /**
     * Scaler Solution
     *
     * Hint 1
     * The constraints are small. Have you tried doing just what the question says?
     *
     * Solution Approach
     * The constraints are small. Have you tried doing just what the question says?
     * Since the constraints are small we can generate all subarrays using 2 loops. This can be done in O(N^2).
     * Then find the sum of each subarray and if the sum is less than B we add 1 to our answer.
     * Note that we cannot iterate over the subarray after generating the left index and right index to
     * find the sum as this will increase the time complexity of the solution to O(N^3).
     * We can find the sum of each subarray in O(1) with the help of a prefix sum array,
     * which takes an O(N) precomputation.
     * Please refer to the complete solution for implementation.
     * **/
    private static int solve1(int[] A, int B) {
        int n  = A.length;
        int pref[] = new int[n];
        pref[0] = A[0];
        int ans = 0;
        for(int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + A[i];
        }

        for(int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int sum = pref[j];
                if(i > 0){
                    sum -= pref[i - 1];
                }
                if(sum < B) ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 11, 2, 3, 15};
        int B = 10;
        int result = solve(A, B);
        System.out.println("Result : " + result);
        result = solve1(A, B);
        System.out.println("Result : " + result);
    }
}
