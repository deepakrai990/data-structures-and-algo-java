package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 28/09/22 2:50 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Leap_year_III {
    private static int solve(int A) {
        // a year that is evenly divisible by 100 (for example, 1900)
        // is a leap year only if it is also evenly divisible by 400
        if (A % 100 == 0) {
            if (A % 400 == 0) {
                if (A % 4 == 0){
                    return 1;
                }
            }
            // Any year that is evenly divisible by 4 is a leap year
            // : for example, 1988, 1992, and 1996 are leap years.
        }else if(A % 4 == 0){
            return 1;
        }
        // atlast all other years are not leap year
        return 0;
    }
    public static void main(String[] args) {
        int A = 2020;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
