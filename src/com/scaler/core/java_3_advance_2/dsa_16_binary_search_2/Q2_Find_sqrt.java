package com.scaler.core.java_3_advance_2.dsa_16_binary_search_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/10/23 7:53 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Find_sqrt {
    /**
     * Given a positive number N. Find sqrt(N).
     * Floor of sqrt(N)
     * **/
    private static int floorSqrt(int N) {
        if (N <= 1) return N;
        int left = 1, right = N, result = 0;
        while (left <= result) {
            int mid = (right + left) / 2;
            if (mid < (N / mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int N = 20;
        int result = floorSqrt(N);
        PrintUtils.print(result);
    }
}
