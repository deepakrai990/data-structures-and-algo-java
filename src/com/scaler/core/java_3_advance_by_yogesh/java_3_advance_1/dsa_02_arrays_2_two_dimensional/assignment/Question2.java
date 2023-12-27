package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_02_arrays_2_two_dimensional.assignment;

import java.util.Arrays;

/**
 * @created 19/01/23 11:46 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int n = A.length;
        int m = A[0].length;
        int mod = 1000000007;
        int sum = 0;
        long preSum[][] = new long[n + 1][m + 1];
        //prefix Sum[i][j] denotes the sum of elements of matirx (0, 0) to (i, j)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j] = (A[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1]
                        - preSum[i - 1][j - 1] + mod) % mod;
            }
        }
        int res[] = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int x1 = B[i], y1 = C[i], x2 = D[i], y2 = E[i];
            long ans = preSum[x2][y2] - preSum[x2][y1 - 1] - preSum[x1 - 1][y2] + preSum[x1 - 1][y1 - 1];
            while (ans < 0)
                ans += mod;
            ans = ans % mod;
            res[i] = (int) ans;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] B = {1, 2};
        int[] C = {1, 2};
        int[] D = {2, 3};
        int[] E = {2, 3};
        int[] results = solve(A, B, C, D, E);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
