package com.scaler.core.java_2_intermediate.dsa_18_sorting.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 29/09/22 9:45 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int[] solve(int[] A) {
        Integer[] input = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(input, Question2::customCompare);
        return Arrays.stream(input).mapToInt(Integer::intValue).toArray();
    }

    private static int customCompare(int a, int b) {
        int countA = 0, countB = 0;
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                countA = countA + 2;
                if (a / i == i) {
                    countA = countA - 1;
                }
            }
        }
        for (int i = 1; i <= Math.sqrt(b); i++) {
            if (b % i == 0) {
                countB = countB + 2;
                if (b / i == i) countB = countB - 1;
            }
        }
        if (countA > countB) return 1;
        else if (countB > countA) return -1;
        if (countA == countB) {
            if (a > b) return 1;
            else return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {6, 8, 9};
        int[] results = solve(A);
        PrintUtils.print1DArray(results);
    }
}
