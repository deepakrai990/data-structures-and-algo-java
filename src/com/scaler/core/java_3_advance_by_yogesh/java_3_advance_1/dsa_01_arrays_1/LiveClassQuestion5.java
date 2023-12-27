package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1;

/**
 * @created 04/01/23 8:03 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion5 {
    /**
     * Given A[N], find maximum subarray sum
     **/
    private static int findMaximumSubarraySum(int[] A) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            ans = Math.max(sum, ans);
            if (sum < 0) {
                sum = 0; // resetting
            }
        }
        /**
         * Time Complexity: O(N)
         * Space Complexity: O(1)
         * **/
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, -6, 8, 2, 9, 4};
        int result = findMaximumSubarraySum(A);
    }
}
