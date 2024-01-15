package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving;

import com.scaler.core.utils.TimeDateUtils;

import java.time.LocalTime;

/**
 * @created 09/09/22 7:48 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_FactorCount {
    /*
      Count the number of factors(divisor) of given number
      **/
    /**
     * Brute Force Solution
     * **/
    private static int factorCount(int N) { // Brute Force Solution
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;
            }
        }
        return count;
    }
    /**
     * Optimize Solution
     * **/
    private static int factorCountOptimize(int N) { // Optimize Solution
        int count = 0;
        for (int i = 1; i <= (int) Math.sqrt(N); i++) {
            if (N % i == 0) {
                if (i != N/i) {
                    count = count + 2;
                } else
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 1000000000;
        System.out.println("------------------------Brute Force Solution------------------------");
        LocalTime start = TimeDateUtils.startTime();
        int factorCount = factorCount(N);
        TimeDateUtils.endTime(start);
        System.out.println("factorCount : " + factorCount);
        System.out.println("------------------------Optimize Solution------------------------");
        LocalTime start1 = TimeDateUtils.startTime();
        int factorCount1 = factorCountOptimize(N);
        TimeDateUtils.endTime(start1);
        System.out.println("factorCount : " + factorCount1);
    }
}
