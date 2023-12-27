package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1;

/**
 * @created 04/01/23 7:40 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion4 {
    /**
     * Rain water Trapping problem
     * Given A[N], where A[i] represents height of the building.
     * Return the amount of water trapped on all buildings.
     **/
    private static int calculateRainWaterTrappedAmount(int[] A) {
        int n = A.length;
        int[] prefixMax = preparePrefixMax(A);
        int[] suffixMax = prepareSuffixMax(A);
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            // Calculate amount of water trapped
            int lefMax = prefixMax[i - 1];
            int rightMax = suffixMax[i + 1];
            int height = Math.min(lefMax, rightMax);
            int amountOfWater = height - A[i];
            if (amountOfWater > 0) {
                ans += amountOfWater;
            }
        }
        return ans;
    }

    private static int[] preparePrefixMax(int[] A) {
        int n = A.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(A[i], prefixMax[i - 1]);
        }
        return prefixMax;
    }

    private static int[] prepareSuffixMax(int[] A) {
        int n = A.length;
        int[] prefixMax = new int[n];
        prefixMax[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefixMax[i] = Math.max(A[i], prefixMax[i + 1]);
        }
        return prefixMax;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1};
        int result = calculateRainWaterTrappedAmount(A);
        System.out.println("Result: " + result);
    }
}
