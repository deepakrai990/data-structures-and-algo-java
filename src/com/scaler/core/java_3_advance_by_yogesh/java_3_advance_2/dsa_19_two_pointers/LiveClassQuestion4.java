package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_19_two_pointers;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 15/02/23 7:20 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion4 {
    /**
     * Given array A[N] with sorted distinct elements.
     * Find triplet (i, j, k) such that A[i] + A[J] + A[K] = sum.
     * Constraints: (i != j != k)
     * Example
     * int[] A = {-8, -4, -1, 2, 3, 5, 7, 9};
     * an int sum = 14;
     **/
    private static boolean findTriplet(int[] A, int sum) {
        int n = A.length, left, right;
        /* Sort the elements */
        Arrays.sort(A);
        /* Now fix the first element one by one and find the other two elements */
        for (int i = 0; i < n - 2; i++) {
            left = i + 1; // index of the first element
            right = n - 1; // index of the last element
            while (left < right) {
                if (A[i] + A[left] + A[right] == sum) return true;
                else if (A[i] + A[left] + A[right] < sum) left++;
                else right--; // arr[i] + arr[l] + arr[r] is greater than sum
            }
        }
        return false; // If no triplet was found
    }

    public static void main(String[] args) {
        int[] A = {-8, -4, -1, 2, 3, 5, 7, 9};
        int sum = 14;
        boolean result = findTriplet(A, sum);
        PrintUtils.printBool(result);
    }
}
