package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward;

/**
 * @created 12/09/22 10:44 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Brute Force Approach.
     * Approach  *  1
     * Time Complexity O(N^2)
     * Space Complexity O(1)
     * **/
    private static int countLeadersInArrayApproach1(int[] A) {
        int N = A.length;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int element = A[i];
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < N; j++) {
                max = Math.max(max, A[j]);
            }
            if (element > max) {
                ans++;
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
    private static int countLeadersInArrayApproach2(int[] A) {
        int N = A.length;
        int count = 1;
        int max = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (A[i] > max) {
                count++;
                max = A[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {15, -1, 7, 2, 5, 4, 2, 3};
        int leadersCount = countLeadersInArrayApproach1(A);
        System.out.println("Approach 1 leadersCount : " + leadersCount);
        leadersCount = countLeadersInArrayApproach2(A);
        System.out.println("Approach 2 leadersCount : " + leadersCount);
    }
}
