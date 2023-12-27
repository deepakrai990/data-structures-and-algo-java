package com.scaler.core.java_2_intermediate.dsa_19_string.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 20/02/23 12:19 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int solve(String A, int B) {
        int[] freq = new int[26];
        int ans = 0;
        for (char c : A.toCharArray()) {
            int i = c - 'a';
            freq[i]++;
            if (freq[i] == 1) {
                ans++;
            }
        }
        if (B < 0 || B == ans) {
            return ans;
        }
        Arrays.sort(freq);
        for (int f : freq) {
            if (B - f >= 0 && f != 0) {
                ans--;
                B -= f;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "abcabbccd";
        int B = 3;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
