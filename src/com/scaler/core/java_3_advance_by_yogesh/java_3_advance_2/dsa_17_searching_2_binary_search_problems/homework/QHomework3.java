package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_17_searching_2_binary_search_problems.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 10/02/23 6:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int solve(int[] A, int B) {
        int left = 0, right = A.length;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = findSubArray(A, mid);
            if (sum <= B) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static long findSubArray(int[] a, int mid) {
        long sum = 0;
        for (int i = 0; i < mid; i++) {
            sum += a[i];
        }
        long ans = sum;
        int st = 0, end = mid;
        while (end < a.length) {
            sum = sum - a[st++] + a[end++];
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    private static int solve1(int[] A, int B) {
        int start = 1;
        int end = A.length;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (check(mid, A, B)) {

                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private static boolean check(int size, int[] A, int B) {
        if (size == 0) {
            return false;
        }
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += A[i];
        }
        if (sum > B) {
            return false;
        }
        int start = 0;
        int end = size;

        while (end < A.length) {
            sum += A[end];
            sum -= A[start];

            if (sum > B) {
                return false;
            }
            end++;
            start++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 10;
        int result = solve(A, B);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        int result1 = solve1(A, B);
        PrintUtils.printInt(result1);
    }
}
