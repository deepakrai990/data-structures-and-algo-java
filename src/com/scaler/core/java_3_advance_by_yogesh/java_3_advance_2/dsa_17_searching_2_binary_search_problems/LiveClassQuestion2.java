package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_17_searching_2_binary_search_problems;

/**
 * @created 07/02/23 8:09 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Given N distinct elements in an array & array is unsorted.
     * Find element at K th index position in it's sorted form.
     * Input
     * int[] A = {2, 8, 3, 11, 14}
     * int K = 2
     * <p></p>
     * Output
     * int result = 8
     * <p></p>
     * Constraints:- Array can't be modified and No extra space is allowed.
     * <p>
     * T.C: O(n * lof(max - min))
     * S.C: O(1)
     **/
    // Idea use Binary Search
    private static int findElementAtKthIndex(int[] A, int K) {
        int min = A[0], max = A[0], n = A.length;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        int low = min, high = max;
        int ans = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = countSmallerElement(A, mid);
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

    private static int countSmallerElement(int[] A, int value) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < value) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 8, 11, 14};
        int K = 2;
        int result = findElementAtKthIndex(A, K);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
