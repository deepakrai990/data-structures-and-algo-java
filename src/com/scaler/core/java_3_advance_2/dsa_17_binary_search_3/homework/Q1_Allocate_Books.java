package com.scaler.core.java_3_advance_2.dsa_17_binary_search_3.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Allocate_Books {
    private static int books(int[] A, int B) {
        if (A.length < B) return -1;

        int low = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++)
            low = Math.max(low, A[i]);

        long high = 1000000000;
        int ans = 0;
        while (low <= high) {
            int mid = (int) high - ((int) high - low) / 2;
            if (possible(A, mid, B)) {
                high = mid - 1;
                ans = mid;
            } else low = mid + 1;
        }
        return ans;
    }

    public static boolean possible(int A[], long mid, int B) {
        long sum = 0;
        int countofstuds = 1;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > mid) {
                countofstuds++;
                sum = A[i];
            }
        }
        if (countofstuds <= B) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] A = {12, 34, 67, 90};
        int B = 2;
        int result = books(A, B);
        PrintUtils.print(result);
    }
}
