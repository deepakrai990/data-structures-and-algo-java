package com.scaler.contest.daily_coding_problem;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 04/10/23 11:16 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Problem_310 {
    /**
     * Write an algorithm that finds the total number of set bits in all integers between 1 and N.
     * **/
    private static int countSetBitsInRange(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int num = i;
            while (num > 0) {
                count += num & 1; // Check the least significant bit
                num = num >> 1; // Right shift to check the next bit
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int N = 5;
        int result = countSetBitsInRange(N);
        PrintUtils.print(result);
    }
}
