package com.scaler.core.java_3_advance_1.dsa_01_arrays_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:10 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Max_Sum_Contiguous_Subarray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int maxSubArray(final int[] A) {
        int sum = Integer.MIN_VALUE;
        int last = 0;

        for (int num : A) {
            last += num;
            sum = Math.max(sum, last);
            if (last < 0)
                last = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[]  A = {1, 2, 3, 4, -10};
        int result = maxSubArray(A);
        PrintUtils.print(result);
    }
}
