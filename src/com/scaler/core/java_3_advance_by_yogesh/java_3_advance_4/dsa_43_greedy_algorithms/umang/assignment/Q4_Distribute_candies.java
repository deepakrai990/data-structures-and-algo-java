package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_4.dsa_43_greedy_algorithms.umang.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 30/03/23 1:39 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Distribute_candies {
    private static int solve(int A, int B, int C) {
        int start = 1;
        int end = B + C;
        int ans = 0;
        while (start <= end) {
            int possibleCandies = end - (end - start) / 2;

            int distribution1 = B / possibleCandies;
            int distribution2 = C / possibleCandies;

            if (distribution1 + distribution2 >= A) {
                ans = possibleCandies;
                start = possibleCandies + 1;
            } else {
                end = possibleCandies - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 4, B = 4, C = 5;
        int result = solve(A, B, C);
        PrintUtils.print(result);
    }
}
