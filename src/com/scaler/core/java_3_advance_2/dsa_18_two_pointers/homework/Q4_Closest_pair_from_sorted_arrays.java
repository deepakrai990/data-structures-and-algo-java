package com.scaler.core.java_3_advance_2.dsa_18_two_pointers.homework;

/**
 * @created 02/04/23 7:12 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Closest_pair_from_sorted_arrays {
    private static int[] solve(int[] A, int[] B, int C) {
        int m = A.length;
        int n = B.length;
        int result[] = new int[2];
        int mindiff = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 1;
        while (left < m && right >= 0) {
            int diff = Math.abs(A[left] + B[right] - C);
            if (diff == mindiff && A[left] == result[0]) {
                result[1] = B[right];
            }
            if (diff < mindiff) {
                mindiff = diff;
                result[0] = A[left];
                result[1] = B[right];
            }
            if ((A[left] + B[right]) > C) right--;
            else left++;
        }
        return result;
    }
}
