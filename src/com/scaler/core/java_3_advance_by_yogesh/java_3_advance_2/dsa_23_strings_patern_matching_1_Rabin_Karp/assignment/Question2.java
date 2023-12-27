package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_23_strings_patern_matching_1_Rabin_Karp.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 21/02/23 10:22 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int solve(String A, String B) {
        int N = A.length(), M = B.length(), count = 0;

        long hashB = 0, hashA = 0, d = 1;
        long mod = 1000000007;

        for(int i = 0; i < M-1; i++) {

            hashB = ((hashB) * 26 + (B.charAt(i) - 'a')) % mod;
            hashA = ((hashA) * 26 + (A.charAt(i) - 'a')) % mod;

            d = (d * 26) % mod;
        }

        hashB = ((hashB) * 26 + (B.charAt(M - 1) - 'a')) % mod;
        hashA = ((hashA) * 26 + (A.charAt(M - 1) - 'a')) % mod;

        if(hashA == hashB) count++;

        for(int i = M; i < N; i++) {
            hashA = ((hashA - d * (A.charAt(i - M) - 'a')) * 26 + (A.charAt(i) - 'a') + mod) % mod;
            if(hashA == hashB) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String A = "acbac";
        String B = "ac";
        int result;
        result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
