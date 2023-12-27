package com.scaler.core.java_3_advance_3.dsa_34_trees_4_lowest_common_ancestor;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 11/11/23
 * @project scaler_course_code
 */
public class Q6_Recover_Sorted_Array {
    /**
     * Question: Recover Sorted Array
     * Given A[N], which is formed by swapping two distinct index positions in a sorted increasing order
     * A[]. One swap to get an original sorted array.
     **/
    public static void recoverSortedArray(int[] A) {
        int n = A.length;
        for (int i = n - 1; i > 0; i--) {
            // Check if A[i] is not in order
            if (A[i] < A[i - 1]) {
                // Find the other element to be swapped with arr[i]
                int j = i - 1;
                while (j >= 0 && A[i] < A[j])
                    j--;
                // Swap the pair
                int temp = A[i];
                A[i] = A[j + 1];
                A[j + 1] = temp;
                break;
            }
        }
    }
    public static void recoverSortedArray1(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            int firstOccranceIndex = 0;
            if (A[i] > A[i + 1]) {
                firstOccranceIndex = i;
                int secondOccurenceIndex = 0;
                for (int j = i + 1; j < n - 1; j++) {
                    if (A[j] > A[j + 1]) {
                        secondOccurenceIndex = j + 1;
                    }
                }
                swap(A, firstOccranceIndex, secondOccurenceIndex);
                break;
            }
        }
    }
    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }

    public static void main(String[] args) {
        int[] A =  {4, 10, 19, 14, 18, 12, 25, 28};
        PrintUtils.print(A);
        recoverSortedArray(A);
        PrintUtils.print(A);
        int[] A1 =  {2, 6, 23, 10, 14, 19, 8, 40, 51};
        PrintUtils.print(A1);
        recoverSortedArray1(A1);
        PrintUtils.print(A1);
    }
}
