package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_17_searching_2_binary_search_problems;

/**
 * @created 07/02/23 12:37 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion4 {
    /**
     * Given two sorted arrays.
     * int[] A = {4, 5, 10, 11};
     * int[] B = {1, 2, 7, 8, 12, 13};
     * Find k th index position element in merged sorted array.
     * int K = 4;
     * Input
     * int[] A = {4, 5, 10, 11};
     * int[] B = {1, 2, 7, 8, 12, 13};
     * int K = 4;
     * **/
    private static int findElementAtKthIndexFromTwoSortedArray(int[] A, int[] B, int K) {
        int n = A.length, m = B.length;
        int min = Math.min(A[0], B[0]), max = Math.max(A[n - 1], B[m - 1]);
        int low = min, high = max, ans = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            count += countElement(A, mid); // Optimised By Using Binary Search
            count += countElement(B, mid); // Optimised By Using Binary Search
            if (count == K) {
                ans = mid;
                low = mid + 1;
            } else if (count < K) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    /**
     * Optimised By Using Binary Search
     * **/
    private static int countElement(int[] A, int val) {
        int n = A.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == val) {
                return mid;
            } else if (A[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] A = {4, 5, 10, 11};
        int[] B = {1, 2, 7, 8, 12, 13};
        int K = 4;
        int result = findElementAtKthIndexFromTwoSortedArray(A, B, K);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
