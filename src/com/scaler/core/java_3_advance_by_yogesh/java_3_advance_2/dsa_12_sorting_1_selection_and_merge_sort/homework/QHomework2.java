package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 11/02/23 8:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int solve(int[] A) {
        int res = Integer.MAX_VALUE;
        int N = A.length;
        Arrays.sort(A);

        for (int i = 0; i < N-1; i++){
            int ans = Math.abs(A[i] - A[i+1]);
            res = Math.min(res, ans);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
