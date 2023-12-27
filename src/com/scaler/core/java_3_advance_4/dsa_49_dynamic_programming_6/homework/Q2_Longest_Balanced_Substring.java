package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6.homework;

/**
 * @created 02/04/23 9:05 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Longest_Balanced_Substring {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int LBSlength(final String A) {
        int N = A.length();
        char s[] = A.toCharArray();
        int dp[] = new int[N];
        if (N <= 1) {
            return 0;
        }
        int currmax = 0;
        for (int i = 1; i < N; i++) {
            if ((s[i] == ')' && s[i - 1] == '(') || (s[i] == '}' && s[i - 1] == '{') || (s[i] == ']' && s[i - 1] == '[')) {
                if (i - 2 >= 0) {
                    dp[i] = 2 + dp[i - 2];
                } else {
                    dp[i] = 2;
                }
                currmax = Math.max(currmax, dp[i]);
            } else {
                if (i - dp[i - 1] - 1 >= 0) {
                    if ((s[i] == ')' && s[i - dp[i - 1] - 1] == '(') || (s[i] == '}' && s[i - dp[i - 1] - 1] == '{') || (s[i] == ']' && s[i - dp[i - 1] - 1] == '[')) {
                        if ((i - dp[i - 1] - 2) >= 0) {
                            dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                    currmax = Math.max(currmax, dp[i]);
                }
            }
        }
        return currmax;
    }
}
