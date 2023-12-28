package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 20/02/23 8:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Longest_Subarray_Zero_Sum {
    private static int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        long sum = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum = sum + A[i];
            if (sum == 0) {
                ans = Math.max(ans, i + 1);
            } else if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, -2, 1, 2};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
