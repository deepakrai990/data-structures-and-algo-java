package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 9:03 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Palindromic_Substrings_Count {
    /**
     * Bottom-Up Approach
     */
    private int solve(String A) {
        int count = 0;
        int N = A.length();
        boolean[][] dp = new boolean[N][N];
        for (boolean[] bool : dp) {
            Arrays.fill(bool, false);
        }
        for (int gap = 0; gap < N; gap++) {
            for (int i = 0, j = gap; j < N; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = (A.charAt(i) == A.charAt(j));
                } else {
                    dp[i][j] = (A.charAt(i) == A.charAt(j)) && (dp[i + 1][j - 1]);
                }

                if (dp[i][j]) count++;
            }
        }
        return count;
    }

    /** Top-Down Approach */
    private int solve_1(String A) {
        int count = 0;
        int N = A.length();
        char[][] dp = new char[N][N];
        for(char[] c : dp) Arrays.fill(c, 'U');

        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                dp[i][j] = isPalindrome(A, i, j, dp);
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                if(dp[i][j] == 'T') count++;
            }
        }
        return count;
    }

    private char isPalindrome(String A, int i, int j, char[][] dp){
        if(i >= j) return 'T';
        if(dp[i][j] != 'U') return dp[i][j];

        if(A.charAt(i) == A.charAt(j)){
            dp[i][j] = isPalindrome(A, i+1, j-1, dp);
        } else{
            dp[i][j] = 'F';
        }
        return dp[i][j];
    }
}
