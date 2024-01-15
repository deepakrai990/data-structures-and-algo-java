package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward;

/**
 * @created 12/09/22 10:51 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Closet_Min_Max {
    /**
     * Brute Force Approach.
     * Approach  *  1
     * Time Complexity O(N^2)
     * Space Complexity O(1)
     * **/
    private static int findClosestMinAndMax(int[] A) {
        int N = A.length;
        int minVal = A[0];
        int maxVal = A[0];
        for (int i = 0; i < N; i++) {
            minVal = Math.min(minVal, A[i]);
            maxVal = Math.max(maxVal, A[i]);
        }
        if (minVal == maxVal) {
            return 1;
        }
        int ans = N;
        for (int i = 0; i < N; i++) {
            if (A[i] == minVal) {
                for (int j = i + 1; j < N; j++) {
                    if (A[j] == maxVal) {
                        ans = Math.min(ans, j - i + 1);
                        break;
                    }
                }
            }
            if (A[i] == maxVal) {
                for (int j = i + 1; j < N; j++) {
                    if (A[j] == minVal) {
                        ans = Math.min(ans, j - i + 1);
                        break;
                    }
                }
            }
        }
        return ans;
    }
    /**
     * Optimised Approach.
     * ------> Carry max from right to left.
     * Approach  *  1
     * Time Complexity O(N)
     * Space Complexity O(1)
     * **/
    private static int findClosestMinAndMaxApproach2(int[] A) {
        int N = A.length;
        int minVal = A[0];
        int maxVal = A[0];
        for (int i = 0; i < N; i++) {
            minVal = Math.min(minVal, A[i]);
            maxVal = Math.max(maxVal, A[i]);
        }
        if (minVal == maxVal) {
            return 1;
        }
        int ans = N, mini = -1, maxi = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] == minVal) {
                mini = i;
                if (maxi != -1) {
                    ans = Math.min(ans, maxi - mini + 1);
                }
            }
            if (A[i] == maxVal) {
                maxi = i;
                if (mini != -1) {
                    ans = Math.min(ans, mini - maxi + 1);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1, 4, 3};
        int closestMinMax = findClosestMinAndMax(A);
        System.out.println("Approach 1 closestMinMax : " + closestMinMax);
        closestMinMax = findClosestMinAndMaxApproach2(A);
        System.out.println("Approach 2 closestMinMax : " + closestMinMax);
    }
}
