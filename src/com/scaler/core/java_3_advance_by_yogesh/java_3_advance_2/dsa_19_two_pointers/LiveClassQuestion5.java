package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_19_two_pointers;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 15/02/23 7:41 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion5 {
    /**
     * Question5: Water logging
     * Given array A[N] elements, A[i] represents height of each wall.
     * Find max water accumulated between any two walls.
     * Note: Between two walls, 1 unit distance is present
     * Example
     * int[] A = {3, 7, 4, 5, 2};
     * ans = 10;
     * **/
    /**
     * Brute Force Approach
     * For every pair, calculate the amount of water that can be
     * trapped & update the max ans.
     */
    private static int waterTrapped(int[] ht) {
        int n = ht.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int height = Math.min(ht[i], ht[j]);
                int width = j - i;
                int area = height * width;
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }

    /**
     * Optimised Approach
     * @param A as array
     * @return ans
     * T.C: O(N)
     * S.C: O(1)
     */
    private static int waterTrappedOptimised(int[] A) {
        int n = A.length, ans = 0, i = 0, j = n - 1;
        while (i < j) {
            int height = Math.min(A[i], A[j]);
            int width = j - i;
            int area = height * width;
            ans = Math.max(ans, area);
            if (A[i] < A[j]) i++;
            else j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3, 7, 4, 5, 2};
        int result = waterTrapped(A);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        int result1 = waterTrappedOptimised(A);
        PrintUtils.printInt(result1);
    }
}
