package com.scaler.contest.daily_coding_problem;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Deepak Kumar Rai
 * @created 16/10/23
 * @project scaler_course_code
 */
public class Problem_321 {
    /**
     * Given a positive integer N, find the smallest number of steps it will take to reach 1.
     * <></>
     * There are two kinds of permitted steps:
     * <></>
     * * You may decrement N to N - 1.
     * * If a * b = N, you may decrement N to the larger of a and b.
     * <></>
     * For example, given 100, you can reach 1 in five steps with the
     * following route: 100 -> 10 -> 9 -> 3 -> 2 -> 1.
     * **/
    public static int getStepSize(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("Cannot reach 1 from " + num);
        }
        if (num == 1) {
            return 0;
        }

        int largestFactor = Collections.max(getClosestFactors(num));
        if (largestFactor == num) {
            return getStepSize(num - 1) + 1;
        }
        return Math.min(getStepSize(num - 1) + 1, getStepSize(largestFactor) + 1);
    }

    public static List<Integer> getClosestFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        int a = 1;
        int b = num;
        int factor1 = 1;
        int factor2 = 1;
        while (b > a) {
            if (num % a == 0) {
                factor1 = a;
                factor2 = num / a;
            }
            b = num / a;
            a++;
        }
        factors.add(factor1);
        factors.add(factor2);
        return factors;
    }

    private static int minSteps(int N) {
        if (N <= 1) {
            return 0;  // No steps needed if N is 1 or less
        }

        int[] dp = new int[N + 1];

        // Base cases
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            // Initialize dp[i] to 1 + dp[i - 1] (subtract 1)
            dp[i] = 1 + dp[i - 1];

            // Check if N is divisible by 2 or 3, and if so, update dp[i] with the minimum of the options
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
            }
        }

        return dp[N];
    }
    private static int minSteps_1(int N) {
        if (N <= 1) {
            return 0; // No steps needed if N is 1 or less
        }
        int steps = 0;
        while (N > 1) {
            if (isPerfectSquare(N)) {
                int sqrtN = (int) Math.sqrt(N);
                N = sqrtN;
            } else {
                N--;
            }
            steps++;
        }
        return steps;
    }

    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
    public static void main(String[] args) {
        int N = 100;
        int result = getStepSize(N);
        PrintUtils.print(result);
        result = minSteps(N);
        PrintUtils.print(result);
        result = minSteps_1(N);
        PrintUtils.print(result);
    }
}
