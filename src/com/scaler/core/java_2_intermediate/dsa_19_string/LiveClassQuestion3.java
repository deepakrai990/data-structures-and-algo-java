package com.scaler.core.java_2_intermediate.dsa_19_string;

/**
 * @created 01/10/22 4:03 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {
    private static int expand(char[] charString, int p1, int p2) {
        int N = charString.length;
        while(p1 >= 0 && p2 < N && charString[p1] == charString[p2]) {
            p1--;
            p2++;
        }
        return p2 - p1 - 1;
    }
    private static int longestPalindrome(String A) {
        char[] s = A.toCharArray();
        int N = s.length;
        int ans = 0;
        // for add palindrome
        for(int i = 0; i < N; i++) {
            // center: s[i]
            int p1 = i, p2 = i;
            ans = Math.max(ans, expand(s, p1, p2));
        }
        // for even palindrome
        for(int i = 0; i < N; i++) {
            // center : s[i], s[i + 1]
            int p1 = i, p2 = i + 1;
            ans = Math.max(ans, expand(s, p1, p2));
        }
        return ans;
    }
    public static void main(String[] args) {

    }

}
