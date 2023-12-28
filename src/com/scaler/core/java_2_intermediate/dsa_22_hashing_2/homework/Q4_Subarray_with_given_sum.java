package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 20/02/23 8:53 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Subarray_with_given_sum {
    private static int[] solve(int[] A, int B) {
        int i = 0;
        int j = 1;
        int[] ps = new int[A.length];
        ps[0] = A[0];
        for(int k = 1; k < A.length; k++) {
            ps[k] = ps[k-1] + A[k];
        }

        while(i < A.length && j < A.length) {
            int sum;
            if(i == 0)
                sum = ps[j];
            else
                sum = ps[j] - ps[i-1];
            if(sum == B) {
                return Arrays.copyOfRange(A, i, j + 1);
            } else if(sum < B) {
                j++;
            } else i++;
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        int[]  A = {1, 2, 3, 4, 5};
        int B = 5;
        int[] results = solve(A, B);
        PrintUtils.print1DArray(results);
    }
}
