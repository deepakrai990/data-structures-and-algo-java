package com.scaler.core.java_3_advance_2.dsa_17_binary_search_3;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/10/23 8:56 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Aggressive_cows {
    /**
     * Given N cows and M stalls. All M stalls are on x-axis at different locations.
     * Place all N cows in such a way that the minimum difference between any two cows is maximum.
     * Note 1: In a stall, only one cow can be present.
     * Note 2: All cows have to be placed.
     * **/
    private static int maxMinDistance(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int N = stalls.length;
        int left = 0, right = stalls[N - 1] - stalls[0];
        int maxMinDist = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (isPossible(stalls, N, cows, mid)) {
                maxMinDist = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxMinDist;
    }
    private static boolean isPossible(int[] stalls, int N, int cows, int minDistance) {
        int placedCows = 1;
        int lastPlacedPosition = stalls[0];
        for (int i = 1; i < N; i++) {
            if ((stalls[i] - lastPlacedPosition) >= minDistance) {
                placedCows++;
                lastPlacedPosition = stalls[i];
                if (placedCows == cows) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] stalls = {2, 6, 11, 14, 19, 25, 30, 39, 43};
        int cows = 4;
        int result = maxMinDistance(stalls, cows);
        PrintUtils.print(result);
    }
}
