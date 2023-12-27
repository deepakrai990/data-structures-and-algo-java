package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_4.dsa_43_greedy_algorithms.umang.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 30/03/23 1:36 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Fractional_Knapsack {
    static class Pair {
        int val;
        int weight;
        double fraction;

        Pair(int val, int weight) {
            this.val = val;
            this.weight = weight;
            this.fraction = (double) val / weight;
        }
    }

    private int solve(int[] A, int[] B, int C) {

        Pair[] list = new Pair[A.length];

        for (int i = 0; i < A.length; i++) {
            list[i] = new Pair(A[i], B[i]);
        }

        Arrays.sort(list, (a, b) -> Double.compare(b.fraction, a.fraction));
        double ans = 0;
        for (int i = 0; i < list.length; i++) {
            Pair t = list[i];
            if (C < t.weight) {
                ans += (t.fraction * C * 100);
                return (int) ans;
            } else {
                ans += (t.val * 100);
                C = C - t.weight;
            }
        }
        return (int) (ans);
    }

    public static void main(String[] args) {
        int[] A = {60, 100, 120};
        int[] B = {10, 20, 30};
        int C = 50;

        Q1_Fractional_Knapsack solution = new Q1_Fractional_Knapsack();
        int result = solution.solve(A, B, C);
        PrintUtils.print(result);
    }
}
