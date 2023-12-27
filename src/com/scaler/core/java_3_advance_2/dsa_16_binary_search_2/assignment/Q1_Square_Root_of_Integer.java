package com.scaler.core.java_3_advance_2.dsa_16_binary_search_2.assignment;

/**
 * @created 02/04/23 7:19 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Square_Root_of_Integer {
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

    public static void main(String[] args) {

    }
}
