package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Intersecting_chords_in_a_circle_1 {
    /**
     * Problem: Intersecting chords in a circle
     * Given an N pair of points in a circle.
     * Number of ways to draw N chords such that no two chords intersect.
     * Chord: Line drawn between two points.
     * Name of Series called Catalan Series (Need to learn this topic)
     * **/
    static int[] DP;
    private static int solve(int N) {
        DP = new int[N + 1];
        Arrays.fill(DP, -1);
        return chords(N);
    }
    private static int chords(int i) {
        if (i == 0) {
            return 1;
        }
        if (DP[i] == -1) {
            int c = 0;
            for (int j = i - 1; j >= 0; j--) {
                c = c + chords(j) * chords(i - j - 1);
            }
            DP[i] = c;
        }
        return DP[i];
    }
    public static void main(String[] args) {
        int N = 5; //4; //3;
        int result = solve(N);
        PrintUtils.print(result);

        System.out.println("Number of ways to draw non-intersecting chords: " + result);
    }
}
