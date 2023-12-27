package com.scaler.core.java_3_advance_2.dsa_14_sorting_3;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 26/09/23 8:25 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Rearrange_Array_1 {
    /**
     * Given N Array elements. Rearrange array
     * such that
     * 1. A[0] should go to it's sorted position
     * 2. All elements <= A[0] should go it's left
     * 3. All elements > A[0] should go it's right
     * **/
    private static int[] rearrangeArr(int[] A) {
        int N = A.length, P1 = 0, P2 = N - 1;
        int[] temp = new int[N];
        for (int i = 1; i < N; i++) {
            if (A[i] <= A[0]) {
                temp[P1] = A[i];
                P1++;
            } else {
                temp[P2] = A[i];
                P2--;
            }
        }
        temp[P1] = A[0];
        return temp;
    }

    private static int[] rearrangeArr_1(int[] A) {
        int N = A.length;
        int[] tempArr = new int[N];
        int startIndexVal = A[0];
        int P1 = 0;
        int P2 = N - 1;
        for (int i = 1; i < N; i++) {
            if (startIndexVal >= A[i]) {
                tempArr[P1++] = A[i];
            } else {
                tempArr[P2--] = A[i];
            }
        }
        tempArr[P1] = startIndexVal;
        return tempArr;
    }
    public static void main(String[] args) {
        int[] A = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14};
        int[] results = rearrangeArr_1(A);
        PrintUtils.print1DArray(A);
        PrintUtils.printNewLine();
        PrintUtils.print1DArray(results);
    }
}
