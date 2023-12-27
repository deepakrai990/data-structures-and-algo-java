package com.scaler.core.java_3_advance_2.dsa_14_sorting_3;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 26/09/23 9:57 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Rearrange_Arrays_3 {
    /**
     * Given A[N] & subarray [start  end].
     * Rearrange subarray [start  end] such that A[start] should be in correct
     * position of subarray.
     * **/
    private static int partision(int[] A, int start, int end) {
        int P1 = start + 1, P2 = end;
        while (P1 <= P2) {
            if (A[start] >= A[P1]) P1++;
            else if (A[start] < A[P2]) P2--;
            else {
                swap(A, P1, P2);
                P1++; P2--;
            }
        }
        swap(A, start, P2);
        return P2;
    }
    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
    public static void main(String[] args) {
        int[] A = {10, 3, 8, 6, 14, 7, 4, 12, 7, 1};
        int start = 0, end = A.length - 1;
        int pivot = partision(A, start, end);
        PrintUtils.print(pivot);
    }
}
