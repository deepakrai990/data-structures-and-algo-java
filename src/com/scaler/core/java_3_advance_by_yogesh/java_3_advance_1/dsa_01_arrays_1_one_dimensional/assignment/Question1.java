package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1_one_dimensional.assignment;

/**
 * @created 20/01/23 8:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int maxSubArray(final int[] A) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int num : A) {
            sum += num;
            ans = Math.max(ans, sum);
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(A);
        System.out.println("Result : " + result);
    }
}
