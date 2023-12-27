package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_17_searching_2_binary_search_problems;

import java.util.stream.IntStream;

/**
 * @created 07/02/23 12:05 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {
    /**
     * Given two unsorted arrays.
     * int[] A = {2, 10, 6, 3};
     * int[] B = {1, 7, 8, 4, 11, 15};
     * Find K th index position element in merge sorted array.
     * Constraints:- No extra space is allowed.
     **/
    /**
     * T.C: O((n + m) * log(max - min))
     * S.C: O(1)
     * **/
    private static int findElementAtKthIndexFromTwoArray(int[] A, int[] B, int K) {
        int min = IntStream.concat(IntStream.of(A), IntStream.of(B)).min().getAsInt();
        int max = IntStream.concat(IntStream.of(A), IntStream.of(B)).max().getAsInt();
        int low = min, high = max, ans = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            count += countSmallerElement(A, mid);
            count += countSmallerElement(B, mid);
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
        int[] A = {2, 10, 6, 3};
        int[] B = {1, 7, 8, 4, 11, 15};
        int K = 5;
        printMinAndMaxFromTwoArrays(A, B);
        int result = findElementAtKthIndexFromTwoArray(A, B, K);
        System.out.printf("%s%5d", "Result: ", result);
    }
    private static void printMinAndMaxFromTwoArrays(int[] A, int[] B) {
        int N = A.length > B.length ? A.length : B.length;
        int max = 0, min = 0;
        for (int i = 0; i < N; i++) {
            if (A.length > i) {
                min = Math.min(min, A[i]);
                max = Math.max(max, A[i]);
            }
            if (B.length > i) {
                min = Math.min(min, B[i]);
                max = Math.max(max, B[i]);
            }
        }
        System.out.println("max element is:" + max);
        System.out.println("min element is:" + min);
    }
}
