package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_18_searching_3_binary_search_on_answer.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 11/02/23 5:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
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
        PrintUtils.printInt(result);
    }
}
