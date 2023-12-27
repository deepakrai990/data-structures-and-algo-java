package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2.homework;

/**
 * @created 02/04/23 10:20 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Min_Sum_Path_in_Matrix {
    //top-down approach with memoization
    Integer[][] dp;

    private int minPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        dp = new Integer[n][m];
        return findMinSum(0, 0, n, m, A);
    }

    private int findMinSum(int x, int y, int n, int m, int[][] A) {
        if (x >= n || y >= m)
            return 10001;
        if (x == n - 1 && y == m - 1)
            return A[x][y];
        if (dp[x][y] != null)
            return dp[x][y];

        int down = findMinSum(x + 1, y, n, m, A);
        int right = findMinSum(x, y + 1, n, m, A);
        dp[x][y] = A[x][y] + Math.min(down, right);
        return dp[x][y];
    }


    //bottom-up approach O(N) space complexity
    private int minPathSum_1(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int dp[] = new int[m];
        dp[0] = A[0][0];
        for (int col = 1; col < m; col++)
            dp[col] = dp[col - 1] + A[0][col];

        for (int row = 1; row < n; row++) {
            int leftBoundary = dp[0];
            for (int col = 0; col < m; col++) {
                if (col == 0) {
                    dp[col] += A[row][col];
                    leftBoundary = dp[col];
                } else {
                    dp[col] = A[row][col] + Math.min(leftBoundary, dp[col]);
                    leftBoundary = dp[col];
                }
            }
        }
        return dp[m - 1];
    }

}
