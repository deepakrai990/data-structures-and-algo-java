package com.scaler.core.java_2_intermediate.dsa_11_arrays_interview_problems_1.assignment;

/**
 * @created 26/09/22 8:54 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Count_Increasing_Triplets {
    private static int solve(int[] A) {
        int N = A.length;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int l = 0, r = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    l++;
                }
            }
            for (int j = i + 1; j < N; j++) {
                if (A[i] < A[j]) {
                    r++;
                }
            }
            int count = l * r;
            ans = ans + count;
        }
        return ans;
    }

    private static int solve1(int[] A) {
        int n = A.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    l += 1;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (A[i] < A[j]) {
                    r += 1;
                }
            }
            ans += (l * r);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 3};
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
