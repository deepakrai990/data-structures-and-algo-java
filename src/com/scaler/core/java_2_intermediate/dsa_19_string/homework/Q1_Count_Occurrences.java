package com.scaler.core.java_2_intermediate.dsa_19_string.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:19 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Count_Occurrences {
    private static int solve(String A) {
        int count = 0;
        while (A.indexOf("bob") != -1) {
            int index = A.indexOf("bob");
            A = A.substring(index + 2, A.length());
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "bobob";
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
