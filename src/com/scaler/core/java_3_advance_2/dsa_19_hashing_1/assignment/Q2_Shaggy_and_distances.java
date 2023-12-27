package com.scaler.core.java_3_advance_2.dsa_19_hashing_1.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 02/04/23 7:07 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Shaggy_and_distances {
    private static int solve(int[] A) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hm = new HashMap();
        if (A.length < 2) { //possible edge case
            return -1;
        }
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (hm.containsKey(A[i])) {
                cnt++;
                min = Math.min(min, Math.abs(i - hm.get(A[i])));
            } else {
                hm.put(A[i], i);
            }
        }
        if (cnt == 0) { //No matching pairs
            return -1;
        } else {
            return min;
        }
    }

    public static void main(String[] args) {
        int[] A = {7, 1, 3, 4, 1, 7};
        int result = solve(A);
        PrintUtils.print(result);
    }
}
