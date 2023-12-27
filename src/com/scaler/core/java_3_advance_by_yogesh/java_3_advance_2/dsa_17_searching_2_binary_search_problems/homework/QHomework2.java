package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_17_searching_2_binary_search_problems.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 10/02/23 6:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int solve(int[] A, int B) {
        int N = A.length;
        Arrays.sort(A);
        int low = 0;
        //Maximum sum possible is the sum of last 3 elements in a sorted array
        int high = A[N - 1] + A[N - 2] + A[N - 3];
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            //Check the count of triplets for a value of mid
            if (checkCnt(A, mid) < B) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private static int checkCnt(int[] A, int mid) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int j = i + 1, k = A.length - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                if (sum < mid) {
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 7, 3, 2};
        int B = 9;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
