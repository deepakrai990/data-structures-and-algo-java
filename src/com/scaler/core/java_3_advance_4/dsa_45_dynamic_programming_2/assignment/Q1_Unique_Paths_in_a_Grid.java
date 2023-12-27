package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2.assignment;

/**
 * @created 02/04/23 10:17 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Unique_Paths_in_a_Grid {
    //bottom up approach
    int dp[][];

    private int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        dp = new int[n][m];
        return findUniquePath(0, 0, n, m, A);
    }

    private int findUniquePath(int x, int y, int n, int m, int[][] A) {
        if (x >= n || y >= m || A[x][y] == 1)
            return 0;
        if (x == n - 1 && y == m - 1)
            return 1;
        if (dp[x][y] != 0)
            return dp[x][y];
        int down = findUniquePath(x + 1, y, n, m, A);
        int right = findUniquePath(x, y + 1, n, m, A);

        dp[x][y] = down + right;
        return dp[x][y];
    }


    //top-down approach
    private int uniquePathsWithObstacles_1(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int dp[][] = new int[n + 1][m + 1];
        if (A[0][0] == 1 || A[n - 1][m - 1] == 1)
            return 0;

        dp[0][1] = 1;//to make starting point 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1][j - 1] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n][m];
    }

}
