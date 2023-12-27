package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_15_searching_1_binary_search_on_array.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 12/02/23 9:11 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int solve(int A, int B, int[][] C) {
        for (int[] a : C) {
            Arrays.sort(a);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A - 1; i++) {
            for (int j = 0; j < B; j++) {
                int target = C[i][j];
                int high = B - 1;
                int low = 0;
                int lowerbound = -1;
                int upperbound = -1;
                while (low <= high) {
                    int mid = (high + low) >> 1;
                    if (C[i + 1][mid] == target) return 0;
                    if (C[i + 1][mid] < target) {
                        low = mid + 1;
                        lowerbound = C[i + 1][mid];
                    } else {
                        high = mid - 1;
                        upperbound = C[i + 1][mid];
                    }
                }

                if (lowerbound != -1 && upperbound != -1)
                    ans = Math.min(ans, Math.min(target - lowerbound, upperbound - target));
                else if (lowerbound != -1 && upperbound == -1)
                    ans = Math.min(ans, target - lowerbound);
                else if (lowerbound == -1 && upperbound != -1)
                    ans = Math.min(ans, upperbound - target);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 3;
        int B = 2;
        int[][] C = {{7, 3}, {2, 1}, {4, 9}};
        int result = solve(A, B, C);
        PrintUtils.printInt(result);
    }
}
