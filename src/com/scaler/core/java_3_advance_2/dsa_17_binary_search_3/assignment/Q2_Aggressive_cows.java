package com.scaler.core.java_3_advance_2.dsa_17_binary_search_3.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 7:16 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Aggressive_cows {
    private static int solve(int[] A, int B) {
        Arrays.sort(A);
        int N = A.length;
        int low = 1, high = A[N - 1] - A[0], ans = 0;
        while (low <= high) {
            int mid = ((low + high) >> 1);
            if (check(A, mid, B)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean check(int A[], int mid, int B) {
        int previousCow = A[0];
        int totalCows = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - previousCow >= mid) {
                totalCows++;
                previousCow = A[i];
                if (totalCows == B) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 3;
        int result = solve(A, B);
        PrintUtils.print(result);
    }
}
