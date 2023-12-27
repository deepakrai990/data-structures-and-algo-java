package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_23_strings_patern_matching_1_Rabin_Karp.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 21/02/23 10:23 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static String solve(String A) {
        String[] str = A.split(" ");
        StringBuilder reverseString = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (i != 0) {
                reverseString.append(str[i] + " ");
            } else {
                reverseString.append(str[i]);
            }
        }
        return reverseString.toString();
    }

    private static String solve1(String A) {
        //Using StringBuilder to reverse original string
        //to remove leading and trailing spaces like (_ _ the_ _)
        String B = A.trim();
        // array of string [the|sky|is|blue] with the help of split fun
        String[] words = B.split(" ");
        StringBuilder revStr = new StringBuilder();
        //now use reverse loop to array words and store the reverse value in revStr string
        for (int i = words.length - 1; i >= 0; i--) {
            //like store word in reverse form (blue is sky the)
            revStr.append(words[i] + " ");
        }
        //convert stringBuilder to String and trim the last space.
        return revStr.toString().trim();
    }

    public static void main(String[] args) {
        String A = "the sky is blue";
        String result = solve(A);
        PrintUtils.printString(result);
        PrintUtils.printNewLine();
        result = solve1(A);
        PrintUtils.printString(result);
    }
}
