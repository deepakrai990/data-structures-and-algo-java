package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2.assignment;

/**
 * @created 02/04/23 10:20 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Dungeon_Princess {
    public int calculateMinimumHP(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int dp[] = new int[m];
        //filling dp from bottom left to a top right

        if (A[n - 1][m - 1] <= 0)
            dp[m - 1] = (A[n - 1][m - 1] * -1) + 1;
        else
            dp[m - 1] = 1;

        //filling last row
        for (int i = m - 2; i >= 0; i--) {
            int val = A[n - 1][i];
            int hpNeed = dp[i + 1] - val;
            if (hpNeed <= 0)
                dp[i] = 1;
            else
                dp[i] = hpNeed;
        }
        //rest of the rows
        for (int i = n - 2; i >= 0; i--) {
            //creating a right boundary for the last column and updating it for the rest of columns
            int rightBoundary = 99999;
            for (int j = m - 1; j >= 0; j--) {
                int right = rightBoundary + (A[i][j] * -1);
                int down = dp[j] + (A[i][j] * -1);
                int hpNeed = Math.min(right, down);
                if (hpNeed <= 0)
                    dp[j] = 1;
                else
                    dp[j] = hpNeed;
                rightBoundary = dp[j];
            }
        }
        return dp[0];
    }
}
