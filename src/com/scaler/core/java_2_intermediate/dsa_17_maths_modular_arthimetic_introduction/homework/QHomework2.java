package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 28/09/22 2:50 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int solve(String A) {
        int N = A.length();
        int num;
        if (N >= 3) {
            num = Integer.parseInt(A.substring(N - 3));
        } else {
            num = Integer.parseInt(A);
        }
        if (num % 8 == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String A = "123";
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
