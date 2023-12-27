package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:00 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Make_String_Palindrome {
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
