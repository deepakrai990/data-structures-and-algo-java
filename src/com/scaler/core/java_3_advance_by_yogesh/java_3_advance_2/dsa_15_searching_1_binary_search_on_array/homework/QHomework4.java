package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_15_searching_1_binary_search_on_array.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 12/02/23 9:11 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    private static int solve(int A) {
        if (A == 0)
            return 0;
        long l = 0, r = A, ans = 0;

        while (l <= r) {
            long mid = (l + r) / 2;

            if ((mid * (mid + 1)) / 2 <= (long) A) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int  A = 20;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
