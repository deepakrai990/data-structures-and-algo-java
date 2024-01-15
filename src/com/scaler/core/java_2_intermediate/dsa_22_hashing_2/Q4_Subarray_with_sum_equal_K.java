package com.scaler.core.java_2_intermediate.dsa_22_hashing_2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q4_Subarray_with_sum_equal_K {
    /**
     * Problem: Check if there exists a subarray with sum equals to K
     * **/
    // Approach 1
    private static boolean subarrayWithSumK(int[] A, int K) {
        int N = A.length;
        Set<Integer> hs = new HashSet<>();
        int[] pfSum = createPfSum(A);
        for (int i = 0; i < N; i++) {
            int a = pfSum[i]; // sum = sum + A[i]
            int b = a - K;
            // Edge case
            if (pfSum[i] == K) { // (sum == K)
                return true;
            }
            if (hs.contains(b)) {
                return true;
            }
            hs.add(a); // hs.add(sum)
        }
        return false;
    }
    private static int[] createPfSum(int[] A) {
        int N = A.length;
        int[] pfSum = new int[N];
        pfSum[0] = A[0];
        for (int i = 1; i < N; i++) {
            pfSum[i] = pfSum[i - 1] + A[i];
        }
        return pfSum;
    }
    // Approach 2
    // Function to check if there exists a subarray with sum equal to K using HashSet
    private static boolean hasSubarrayWithSum(int[] array, int target) {
        // Use a HashSet to store a running sum
        HashSet<Integer> runningSumSet = new HashSet<>();
        // Initialize variable for a running sum
        int runningSum = 0;
        // Iterate through the array
        for (int i = 0; i < array.length; i++) {
            runningSum += array[i];
            // Check if the current running sum equals K
            if (runningSum == target) {
                return true; // Subarray found
            }
            // Check if the complement exists in the HashSet
            if (runningSumSet.contains(runningSum - target)) {
                return true; // Subarray found
            }
            // Add the current running sum to the HashSet
            runningSumSet.add(runningSum);
        }
        // No subarray with sum equal to K found
        return false;
    }
    public static void main(String[] args) {
        int[] A = {2, 2, 1, -3, 4, 3, 1, -2, -3, 2};
        int K = 3;

        boolean result = subarrayWithSumK(A, K);
        System.out.println("Subarray with Sum " + K + " Exists: " + result);

        result = hasSubarrayWithSum(A, K);
        System.out.println("Subarray with Sum " + K + " Exists: " + result);
    }
}
