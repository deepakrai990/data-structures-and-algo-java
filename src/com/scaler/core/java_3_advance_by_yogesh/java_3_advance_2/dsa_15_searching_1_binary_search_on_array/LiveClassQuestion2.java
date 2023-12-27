package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_15_searching_1_binary_search_on_array;

/**
 * @created 06/02/23 11:25 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Given a sorted array of elements. Find first index of a given target element.
     * int[] A = {-5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 5, 8, 10, 10, 15, 16};
     * int K = 5;
     * T.C: O(log n)
     * S.C: O(1)
     * **/
    private static int findFirstIndex(int[] A, int K) {
        int n = A.length;
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == K) {
                ans = mid;
                high = mid - 1;
            } else if (A[mid] < K) {
                low = mid + 1;
            } else if (A[mid] > K) {
                high = mid - 1;
            }
        }
        return ans;
    }
    private static int findLastIndex(int[] A, int K) {
        int n = A.length;
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == K) {
                ans = mid;
                low = mid + 1;
            } else if (A[mid] < K) {
                low = mid + 1;
            } else if (A[mid] > K) {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {-5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 5, 8, 10, 10, 15, 16};
        int K = 5;
        int result = findFirstIndex(A, K);
        System.out.printf("%s%5d", "Result for first index : ", result);
        System.out.println();
        int result1 = findLastIndex(A, K);
        System.out.printf("%s%7d", "Result for last index : ", result1);
    }
}
