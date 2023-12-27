package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Create_Prefix_and_Suffix_of_String {
    /**
     * Create Prefix and suffix of String
     * **/
    public static String[] createPrefixes(String string) {
        int N = string.length();
        String[] prefixArr = new String[N];
        for (int i = 1; i <= N; i++) {
            prefixArr[i - 1] = string.substring(0, i);
        }
        return prefixArr;
    }
    public static String[] createSuffixes(String string) {
        int N = string.length();
        String[] suffixArr = new String[N];
        for (int i = string.length() - 1; i >= 0; i--) {
            suffixArr[N - i - 1] = string.substring(i);
        }
        return suffixArr;
    }
    public static void main(String[] args) {
        String s = "deepak";
        String[] prefix = createPrefixes(s);
        String[] suffix = createSuffixes(s);
        PrintUtils.print(prefix);
        PrintUtils.printNewLine();
        PrintUtils.print(suffix);
    }
}
