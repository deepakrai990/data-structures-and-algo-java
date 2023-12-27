package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2.assignment;

import java.util.ArrayList;

/**
 * @created 02/04/23 10:19 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Min_Sum_Path_in_Triangle {
    //top-down approach
    Integer[][] dp;

    private int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        dp = new Integer[n][n];
        return findMinSum(0, 0, n, a);
    }

    private int findMinSum(int row, int col, int n, ArrayList<ArrayList<Integer>> a) {
        if (row == n)
            return 0;
        if (dp[row][col] != null)
            return dp[row][col];

        int left = findMinSum(row + 1, col, n, a);
        int right = findMinSum(row + 1, col + 1, n, a);
        dp[row][col] = a.get(row).get(col) + Math.min(left, right);
        return dp[row][col];
    }


    //bottom-up approach
    private int minimumTotal_1(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                int val1 = Integer.MAX_VALUE;
                int val2 = Integer.MAX_VALUE;
                //element came from above row with same column
                if (i != j) {
                    val1 = a.get(i).get(j) + a.get(i - 1).get(j);
                }
                //element came from above row from j-1 column
                if (j > 0) {
                    val2 = a.get(i).get(j) + a.get(i - 1).get(j - 1);
                }
                a.get(i).set(j, Math.min(val1, val2));
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < a.get(n - 1).size(); i++) {
            minSum = Math.min(minSum, a.get(n - 1).get(i));
        }
        return minSum;
    }
}
