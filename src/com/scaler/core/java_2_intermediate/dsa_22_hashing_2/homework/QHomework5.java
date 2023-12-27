package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 20/02/23 8:53 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework5 {
    private static int solve(int[] A, int B) {
        int n = A.length;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        int[] preSum = new int[n];
        // add this to check if the sub array starts from 0 index is having sum B
        hm.put(0, 1);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                preSum[i] = A[i];
            } else {
                preSum[i] = preSum[i - 1] + A[i];
            }

            if (hm.containsKey(preSum[i] - B)) {
                ans += hm.get(preSum[i] - B);
            }

            if (hm.containsKey(preSum[i])) {
                hm.put(preSum[i], hm.get(preSum[i]) + 1);
            } else {
                hm.put(preSum[i], 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 1};
        int B = 1;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
