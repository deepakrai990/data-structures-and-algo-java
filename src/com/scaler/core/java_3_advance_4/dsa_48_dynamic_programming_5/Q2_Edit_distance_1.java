package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q2_Edit_distance_1 {
    /**
     * Problem: Edit distance
     * Given two strings S1 and S2.
     * Minimum operation to perform on S1 so that S1 becomes S2.
     * In one operation of S1
     *      i -> insert a chat at any position in S1
     *      d -> delete a char at any position in S1
     *      r -> replace a chat at any position in S1 with ant char.
     * **/
    static int[][] DP;
    private static int solve(String S1, String S2, int N, int M) {
        DP = new int[N][M];
        for (int[] row: DP) {
            Arrays.fill(row, -1);
        }
        return edit(S1, S2, N - 1, M - 1);
    }
    private static int edit(String S1, String S2, int i, int j) {
        if (i < 0) {
            /**
             * Say      S1[0  -  i]      S2[0  -  j]
             * chars         0              j + 1    chars
             * **/
            return j + 1; // Insert j + 1 chars in S1 to convert to S2
        }
        if (j < 0) {
            /**
             * Say      S1[0  -  i]      S2[0  -  1]
             * chars         i + 1             0    chars
             * **/
            return i + 1; // Delete i + 1 chars from S1 to convert to S2
        }
        if (DP[i][j] == -1) {
            if (S1.charAt(i) == S2.charAt(j)) { // Match
                DP[i][j] = edit(S1, S2, i - 1, j - 1);
            } else {
                DP[i][j] = 1 + Math.min(
                        Math.min(
                                edit(S1, S2, i, j - 1)/* Insert */,
                                edit(S1, S2, i - 1, j)/* Delete */
                        ),
                        edit(S1, S2, i - 1, j - 1)/* Replace */
                );
            }
        }
        return DP[i][j];
    }
    public static void main(String[] args) {
        String S1 = "dfael";
        String S2 = "fgl";
        int result = solve(S1, S2, S1.length(), S2.length());
        PrintUtils.print(result);
    }
}
