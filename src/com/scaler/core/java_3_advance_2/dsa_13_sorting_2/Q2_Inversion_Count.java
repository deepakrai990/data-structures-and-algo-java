package com.scaler.core.java_3_advance_2.dsa_13_sorting_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 23/09/23 10:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Inversion_Count {
    /**
     * Given an array A[N], Find number of pairs (i, j)
     * such that i < j && A[i] > A[j]
     * **/
    // Bruteforce Approach
    private static int invCount(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) count++;
            }
        }
        return count;
    }
    private static int inversion(int[] A, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int left  = inversion(A, start, mid);
        int right = inversion(A, mid + 1, end);
        int center = merge(A, start, mid, end);
        return left + right + center;
    }
    private static int merge(int[] A, int start, int mid, int end) {
        int P1 = start, P2 = mid + 1, P3 = 0;
        int[] temp = new int[end - start + 1];
        int count = 0;
        while (P1 <= mid && P2 <= end) {
            if (A[P1] <= A[P2]) temp[P3++] = A[P1++];
            else {
                count = count + (mid - P1 + 1);
                temp[P3++] = A[P2++];
            }
        }
        while (P1 <= mid) temp[P3++] = A[P1++];
        while (P3 <= end) temp[P3++] = A[P2++];
        for (int i = start; i <= end; i++) A[i] = temp[i - start];
        return count;
    }
    public static void main(String[] args) {
        int[] A = {10, 3, 8, 15, 6, 12, 2, 18, 7, 1};
        int result = invCount(A);
        PrintUtils.print(result);
        PrintUtils.printNewLine();

        int[] A_1 = {10, 3, 8, 15, 6, 12, 2, 18, 7, 1};
        int result_1 = invCount(A_1);
        PrintUtils.print(result_1);
    }
}
