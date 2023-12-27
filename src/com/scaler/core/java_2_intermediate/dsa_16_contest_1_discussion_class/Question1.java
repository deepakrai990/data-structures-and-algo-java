package com.scaler.core.java_2_intermediate.dsa_16_contest_1_discussion_class;

import java.util.Arrays;

/**
 * @created 26/09/22 4:33 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int[] solve(String A, int[][] B) {
        int charLength = A.length();
        int[] prefixChar = new int[charLength];
        if (isVowel(A.charAt(0))) prefixChar[0] = 1;
        else prefixChar[0] = 0;
        for (int i = 1; i < charLength; i++) {
            if (isVowel(A.charAt(i))) prefixChar[i] = prefixChar[i - 1] + 1;
            else prefixChar[i] = prefixChar[i - 1];
        }

        int[] results = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int start = B[i][0];
            int end = B[i][1];
            int count = 0;
            if (start == 0) count = prefixChar[end];
            else count = prefixChar[end] - prefixChar[start - 1];
            results[i] = count;
        }
        return results;
    }
    private static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public static void main(String[] args) {
        String A = "scaler";
        int[][] B = {{0, 2}, {2, 4}};
        int[] results = solve(A, B);
        System.out.println("Results : " + Arrays.toString(results));
        String A1 = "scaler";
        int[][] B1 = {{0, 2}, {2, 4}};
    }
}
