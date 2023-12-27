package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 19/09/22 4:00 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question8 {
    private static int divideBy2(int n) {
        int count = 0;
        while(n > 1) {
            n /= 2;
            count++;
        }
        if (n == 1) return count;
        else return -1;
    }
    public static void main(String[] args) {
        int n = 51;
        int result = divideBy2(n);
        PrintUtils.printInt(result);
    }
}
