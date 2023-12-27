package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_24_strings__patern_matching_2_z_algorithm.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 24/02/23 12:29 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int solve(String A) {
        StringBuilder s = new StringBuilder();
        s.append(A);

        String rev = s.reverse().toString();
        s.reverse().append("@").append(rev);

        int[] lps = createLPS(s.toString(), s.toString().length());

        return A.length() - lps[lps.length - 1];

    }

    private static int[] createLPS(String A, int N) {
        int[] LPS = new int[N];
        LPS[0] = 0;
        for (int i = 1; i < N; i++) {

            int x = LPS[i - 1];

            while (A.charAt(i) != A.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = LPS[x - 1];
            }
            LPS[i] = x + 1;
        }
        return LPS;
    }

    public static void main(String[] args) {
        String A = "abc";
        int result = solve(A);
        PrintUtils.printInt(result);
    }

}
