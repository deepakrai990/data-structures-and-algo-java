package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_15_searching_1_binary_search_on_array.assignment;

import java.util.Arrays;

/**
 * @created 09/02/23 8:07 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int[] searchRange(final int[] A, int B) {
        int n = A.length;
        int low = 0, high = n - 1, mid = 0;
        int res[] = {-1, -1};
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] == B) break;
            if (A[mid] > B) high = mid - 1;
            else low = mid + 1;
        }

        low = mid;
        high = mid;
        if (A[mid] == B) {
            while (low > -1 && A[low] == B) low--;
            while (high < n && A[high] == B) high++;
            res[0] = low + 1;
            res[1] = high - 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;
        int[] results = searchRange(A, B);
        System.out.printf("%s%5s", "Results: ", Arrays.toString(results));
    }
}
