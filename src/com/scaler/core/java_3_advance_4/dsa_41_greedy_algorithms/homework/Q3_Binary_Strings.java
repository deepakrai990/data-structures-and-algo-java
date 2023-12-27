package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms.homework;

/**
 * @created 02/04/23 11:09 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Binary_Strings {
    private static int solve(String A, int B) {
        int n = A.length();
        int[] flip = new int[n];
        int time = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0)
                flip[i] = flip[i - 1] + flip[i]; // prefix sum of flip

            int bit = A.charAt(i) - '0';
            if ((flip[i] + bit) % 2 == 0) { //need to interchange
                if (i + B > n)
                    return -1;
                else {
                    time++;
                    flip[i]++;
                    if (i + B < n)
                        flip[i + B]--;
                }
            }
        }
        return time;
    }
}
