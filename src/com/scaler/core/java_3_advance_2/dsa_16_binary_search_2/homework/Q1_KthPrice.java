package com.scaler.core.java_3_advance_2.dsa_16_binary_search_2.homework;

/**
 * @created 02/04/23 7:22 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_KthPrice {
    // DO NOT MODIFY THE ARGUMENTS WITH “final” PREFIX. IT IS READ ONLY
    private static int solve(final int[] A, int B) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : A) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = (low + ((high - low) >> 1));
            int count = findCount(A, mid);
            if (count < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int findCount(int[] A, int val) {
        int count = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] <= val) {
                count++;
            }
        }
        return count;
    }
}
