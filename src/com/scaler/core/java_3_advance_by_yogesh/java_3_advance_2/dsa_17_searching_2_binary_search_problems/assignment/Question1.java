package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_17_searching_2_binary_search_problems.assignment;

/**
 * @created 07/02/23 8:27 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int sqrt(int A) {
        int low = 1, high = A, ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid * mid) <= A) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
