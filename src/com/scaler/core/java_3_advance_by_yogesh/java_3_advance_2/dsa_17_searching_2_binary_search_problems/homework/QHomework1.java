package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_17_searching_2_binary_search_problems.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 10/02/23 6:15 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int[] solve(int[] A, int B) {
        Arrays.sort(A);

        long[] prefix = new long[A.length + 1];
        prefix[0] = 0;
        for (int i = 1; i <= A.length; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }

        int max_count = -1;
        int max_num = -1;
        for (int i = 0; i < A.length; i++) {
            int low = 1;
            int high = i + 1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                long sum = prefix[i + 1] - prefix[i + 1 - mid];
                if (1L * A[i] * mid - sum <= B) {
                    if (mid > max_count) {
                        max_count = mid;
                        max_num = A[i];
                    }
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
        }
        return new int[]{max_count, max_num};
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 2, 1};
        int B = 3;
        int[] results = solve(A, B);
        PrintUtils.print1DArray(results);
    }
}
