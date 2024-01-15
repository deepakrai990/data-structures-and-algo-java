package com.scaler.core.java_3_advance_1.dsa_01_arrays_1;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q3_Rain_Water_Trapping_Problem {
    /**
     * Problem: Rain Water Trapping Problem
     * Given array A[N], where A[i] represents the height of the building.
     * Return the amount of water trapped on all buildings.
     * **/
    // Bruteforce Approach
    private static int trapWaterTrapped(int[] heights) {
        int n = heights.length;
        int trappedWater = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = findMax(heights, 0, i);
            int rightMax = findMax(heights, i, n - 1);

            int currentWater = Math.min(leftMax, rightMax) - heights[i];
            trappedWater += Math.max(currentWater, 0);
        }

        return trappedWater;
    }
    private static int findMax(int[] heights, int start, int end) {
        int max = 0;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, heights[i]);
        }
        return max;
    }
    // Optimise Approach
    private static int trapWaterTrapped1(int[] A) {
        int N = A.length, ans = 0;
        int[] prefixMax = calculatePrefixMax(A);
        int[] suffixMax = calculateSuffixMax(A);
        for (int i = 1; i < N - 1; i++) {
            // Calculate the amount of water trapped
            int leftMax = prefixMax[i - 1]; // Max of all 0...(i - 1)
            int rightMax = suffixMax[i + 1]; // <ax of all (i + 1)...(N - 1)
            int height = Math.min(leftMax, rightMax);
            int waterTrapped = height - A[i];
            if (waterTrapped > 0) {
                ans += waterTrapped;
            }
        }
        return ans;
    }
    private static int[] calculatePrefixMax(int[] A) {
        int n = A.length;
        int[] prefixMax = new int[n];
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, A[i]);
            prefixMax[i] = maxSoFar;
        }
        return prefixMax;
    }

    private static int[] calculateSuffixMax(int[] A) {
        int n = A.length;
        int[] suffixMax = new int[n];
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, A[i]);
            suffixMax[i] = maxSoFar;
        }
        return suffixMax;
    }
    private static int trapWaterTrapped2(int[] heights) {
        int n = heights.length;
        int trappedWater = 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                leftMax = Math.max(leftMax, heights[left]);
                trappedWater += Math.max(leftMax - heights[left], 0);
                left++;
            } else {
                rightMax = Math.max(rightMax, heights[right]);
                trappedWater += Math.max(rightMax - heights[right], 0);
                right--;
            }
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        int[] A = {2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1};

        int trappedWater = trapWaterTrapped(A);
        System.out.println("Amount of water trapped (Bruteforce): " + trappedWater);

        trappedWater = trapWaterTrapped1(A);
        System.out.println("Amount of water trapped (Optimise 1): " + trappedWater);

        trappedWater = trapWaterTrapped2(A);
        System.out.println("Amount of water trapped (Optimise 2): " + trappedWater);
    }
}
