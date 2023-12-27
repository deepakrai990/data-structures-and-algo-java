package com.scaler.core.java_2_intermediate.dsa_19_string;

import java.util.Arrays;

/**
 * @created 07/10/22 12:09 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    public  static char[] solve(char[] s) {
        int n = s.length;
        int[] cntArr = new int[26];
        for (int i = 0; i < n; i++) {
            int index = s[i] - 97;
            cntArr[index]++;
        }
        // Modify original char array
        int k = 0;
        for (int i = 0; i < 26; i++) {
            // cntArr[i] = Frequency of ('a' + i)
            char ch = (char) ((int) 'a' + i);
            for (int j = 1; j <= cntArr[i]; j++) {
                s[k] = ch;
                k++;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        char[] chars = "abcebcbace".toCharArray();
        char[] results = solve(chars);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
