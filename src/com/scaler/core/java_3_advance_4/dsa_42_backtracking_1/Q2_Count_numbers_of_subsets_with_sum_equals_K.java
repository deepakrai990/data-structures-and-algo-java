package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 11/12/23
 * @project scaler_course_code
 */
public class Q2_Count_numbers_of_subsets_with_sum_equals_K {
    /**
     * Given A[N], Count no of subsets with the sum equals K
     * **/
    private static int countSubSetsSum(int[] A, int N, int i, int sum, int K) {
        if (i == N) {
            if (sum == K) return 1;
            else return 0;
        }
        // At ith index, we have two choices: Take it or leave it
        sum = sum + A[i]; // Pick ith element
        int c = countSubSetsSum(A, N, i + 1, sum, K); // Count of subsets with a sum equals K
        sum = sum - A[i]; // Leave ith element (undo update)
        c = c + countSubSetsSum(A, N, i + 1, sum, K); // Count of subsets with a sum equals K
        return c;
    }
    public static void main(String[] args) {
        int[] A = {5, 2, 7};
        int N = A.length, i = 0, sum = 0, K = 7;
        int result = countSubSetsSum(A, N, i, sum, K);
        PrintUtils.print(result);
    }
}
