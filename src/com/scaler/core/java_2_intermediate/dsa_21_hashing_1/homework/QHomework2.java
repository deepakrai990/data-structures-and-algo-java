package com.scaler.core.java_2_intermediate.dsa_21_hashing_1.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 4:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int solve(int[] A) {
        int n = A.length;
        int[] pfSum = new int[n];
        pfSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            pfSum[i] = pfSum[i - 1] + A[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    sum = pfSum[j];
                } else {
                    sum = pfSum[j] - pfSum[i - 1];
                }
                if (sum == 0) {
                    ans++;
                }
            }
        }
        return ans % 1000000007;
    }

    public static void main(String[] args) {
        int[] A = {1, -1, -2, 2};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
