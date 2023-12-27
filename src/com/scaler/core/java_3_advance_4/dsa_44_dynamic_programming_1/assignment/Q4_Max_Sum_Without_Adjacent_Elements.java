package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 10:24 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Max_Sum_Without_Adjacent_Elements {
    int dpArr[];

    private int adjacent(int[][] A) {
        this.dpArr = new int[A[0].length];
        Arrays.fill(dpArr, -1);
        return recursion(A, 0);
    }

    private int recursion(int[][] A, int col) {
        if (col >= A[0].length) return 0;

        if (dpArr[col] != -1) return dpArr[col];

        int a = recursion(A, col + 2) + Math.max(A[0][col], A[1][col]); //if curr col selected add the max of the two ele
        int b = recursion(A, col + 1); //if curr col not selected then adjacent one has to be selected
        dpArr[col] = Math.max(a, b); //taking max of the two choices and updating DP array
        return dpArr[col];
    }

    private static int adjacent_1(int[][] A) {
        int n=A[0].length;
        if(n==1) return Math.max(A[0][0],A[1][0]);
        int res[]=new int[n];
        for(int i=0;i<n;i++){//converting 2d to 1d
            res[i]=Math.max(A[0][i],A[1][i]);
        }
        int dp[]=new int[n];
        dp[0]=res[0];
        dp[1]=Math.max(res[0],res[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],res[i]+Math.max(0,dp[i-2]));
        }
        return dp[n-1];
    }
}
