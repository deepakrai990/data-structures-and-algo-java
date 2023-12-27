package com.scaler.core.java_3_advance_2.dsa_18_two_pointers;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/10/23 7:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_3_Sum_Closest_Triplets {
    /**
     * Given array A[N] with sorted distinct elements.
     * Find triplet (i, j, k) such that A[i] + A[J] + A[K] = sum.
     * Constraints: (i != j != k)
     * Example
     * int[] A = {-8, -4, -1, 2, 3, 5, 7, 9};
     * an int sum = 14;
     **/
    private static int threeSumClosestBruteforce(int[] A, int K) {
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = A[i] + A[j] + A[k];
                    int diff = Math.abs(sum - K);
                    if (diff < minDiff) {
                        minDiff = diff;
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;
    }
    private static int threeSumClosest(int[] A, int K) {
        Arrays.sort(A);
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int N = A.length;
        for (int i = 0; i < N; i++) {
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                int sum = A[i] + A[left] + A[right];
                int diff = Math.abs(sum - K);
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }
                if (sum < K) left++;
                else right--;
            }
        }
        return closestSum;
    }
    public static void main(String[] args) {
        int[] A = {-8, -4, -1, 2, 3, 5, 7, 9};
        int K = 14;
        int result = threeSumClosestBruteforce(A, K);
        PrintUtils.print(result);
        PrintUtils.printNewLine();

        result = threeSumClosest(A, K);
        PrintUtils.print(result);
    }
}
