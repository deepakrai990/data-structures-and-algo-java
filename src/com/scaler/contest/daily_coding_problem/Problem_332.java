package com.scaler.contest.daily_coding_problem;

/**
 * @author Deepak Kumar Rai
 * @created 27/10/23
 * @project scaler_course_code
 */
public class Problem_332 {
    public static int countPairs(int M, int N) {
        int count = 0;
        for (int a = 0; a <= M; a++) {
            int b = M - a;
            if ((a ^ b) == N) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int M = 10;
        int N = 6;
        int result = countPairs(M, N);
        System.out.println("Count of positive integer pairs (a, b): " + result);
    }
}
