package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 22/12/23
 * @project scaler_course_code
 */
public class Q2_Find_the_length_of_longest_strictly_increasing_subsequence_2 {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // Create an array to store the length of LIS ending at each index
        int[] lisLength = new int[n];
        // Initialize LIS length for each index as 1 (each element is a valid LIS of length 1)
        Arrays.fill(lisLength, 1);
        // Iterate over each element in the array
        for (int i = 1; i < n; i++) {
            // Check for elements before the current index
            for (int j = 0; j < i; j++) {
                // If the current element is greater than the element at index j,
                // update the LIS length ending at index i if needed
                if (nums[i] > nums[j] && lisLength[i] < lisLength[j] + 1) {
                    lisLength[i] = lisLength[j] + 1;
                }
            }
        }
        // Find the maximum value in the lisLength array
        int maxLIS = 0;
        for (int i = 0; i < n; i++) {
            if (lisLength[i] > maxLIS) {
                maxLIS = lisLength[i];
            }
        }
        return maxLIS;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 6, 3, 7, 9};
        int length = lengthOfLIS(nums);

        System.out.println("Length of Longest Increasing Subsequence: " + length);
    }
}
