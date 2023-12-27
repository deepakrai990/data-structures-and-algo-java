package com.scaler.core.java_2_intermediate.dsa_19_string;

import java.util.Arrays;

/**
 * @created 06/10/22 11:29 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    private static char[] solve(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] = (char) ((int) chars[i] + 32);
            } else {
                chars[i] = (char) ((int) chars[i] - 32);
            }
        }
        return chars;
    }

    /**
     * Without if and else, using bit operator
     * **/
    private static char[] solve1(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            // chars[i] = (char) (((int) chars[i]) ^ 32);
            chars[i] = (char) (((int) chars[i]) ^ (1 << 5));
        }
        return chars;
    }

    public static void main(String[] args) {
        char[] chars = {'A', 'n', 'a', 'C', 'o', 'n', 'D', 'a'}; // "AnaConDa".toCharArray();
        char[] results = solve(chars);
        System.out.println("Results : " + Arrays.toString(results));
        char[] chars1 = {'A', 'n', 'a', 'C', 'o', 'n', 'D', 'a'};
        results = solve1(chars1);
        System.out.println("Results : " + Arrays.toString(results));
    }


}
