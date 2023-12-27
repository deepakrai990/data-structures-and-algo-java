package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5.homework;

/**
 * @created 02/04/23 10:08 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Repeating_Subsequence {
    public int anytwo(String A) {
        String B = A;
        return anytwo_Tabulation(A, B);
    }

    /**
     * Using Tabulation
     */
    private int anytwo_Tabulation(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int maxLength = 0;
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {

                //If Same Index then ignoring those
                if (i == j) {
                    continue;
                }

                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        if (maxLength >= 2) {
            return 1;
        }
        return 0;
    }


    public int anytwo_1(String A) {
        String B = A;
        return anytwo_Memoization(A, B);
    }
    /**
     * Using Memoization
     */
    private int anytwo_Memoization(String A, String B) {
        Integer[][] dp = new Integer[A.length()][B.length()];
        int repeatingSubsequeneCount = getRepeatingSubsequenceLength(A, A.length() - 1, B, B.length() - 1, dp);

        if (repeatingSubsequeneCount >= 2) {
            return 1;
        }
        return 0;
    }

    /**
     * We are using the same String and Same Index initially.
     * So, while checking the character of both the String we are making sure its not the same index.
     * If its not the same index but the characters are same then definitely its part of the repeating subsequence.
     * Otherwise try to explore by taking the current character & without taking the current character
     * and out of those take the Max value one which can form the repeating subsequence.
     */
    private int getRepeatingSubsequenceLength(String A, int indexA, String B, int indexB, Integer[][] dp) {

        if (indexA < 0 || indexB < 0) {
            return 0;
        }

        if (dp[indexA][indexB] != null) {
            return dp[indexA][indexB];
        }
        // If its not the same index but the characters are same then definitely its part of the repeating subsequence.
        // Hence 1 + exploring remaining part
        if (A.charAt(indexA) == B.charAt(indexB) && indexA != indexB) {
            return 1 + getRepeatingSubsequenceLength(A, indexA - 1, B, indexB - 1, dp);
        }
        /**
         *   Otherwise try to explore by taking the current character & without taking the current character
         *   and out of those take the Max value one which can form the repeating subsequence.
         */
        else {
            int choosingA = getRepeatingSubsequenceLength(A, indexA, B, indexB - 1, dp);
            int notChoosingA = getRepeatingSubsequenceLength(A, indexA - 1, B, indexB, dp);

            return dp[indexA][indexB] = Math.max(choosingA, notChoosingA);
        }

    }



}
