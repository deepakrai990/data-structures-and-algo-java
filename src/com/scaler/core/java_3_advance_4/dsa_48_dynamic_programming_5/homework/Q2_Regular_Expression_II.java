package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5.homework;

/**
 * @created 02/04/23 10:07 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Regular_Expression_II {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        return helper(A, B, A.length(), B.length()) ? 1 : 0;
    }

    private boolean helper(String A, String B, int N, int M) {
        if (N == 0 && M == 0) { //1}
            return true;
        }
        if (M == 0) { //2}
            return false;
        }
        if (N <= 0) {   //3}
            for (int i = M - 1; i >= 0; i -= 2) {
                if (B.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (B.charAt(M - 1) == '.') { //4}
            return helper(A, B, N - 1, M - 1);
        } else if (B.charAt(M - 1) == '*') {    //5}
            if (B.charAt(M - 2) == A.charAt(N - 1) || B.charAt(M - 2) == '.') {
                return helper(A, B, N, M - 2) || helper(A, B, N - 1, M);
            } else {
                return helper(A, B, N, M - 2);
            }
        } else {  //6}
            if (A.charAt(N - 1) != B.charAt(M - 1)) {
                return false;
            } else {
                return helper(A, B, N - 1, M - 1);
            }
        }
    }
}
