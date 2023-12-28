package com.scaler.core.java_2_intermediate.dsa_21_hashing_1.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;

/**
 * @created 20/02/23 4:50 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Sub_array_with_0_sum {
    private static int solve(int[] A) {
        if (A[0] == 0) return 1;
        int N = A.length;
        long prefixSum[] = new long[N];
        prefixSum[0] = A[0];

        HashSet<Long> hs = new HashSet();
        hs.add((long)A[0]);

        for (int i=1; i< N; i++) {
            long sum = prefixSum[i-1] + A[i];
            if (sum == 0 || hs.contains(sum)) return 1;
            prefixSum[i] = sum;
            hs.add((long)sum);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
