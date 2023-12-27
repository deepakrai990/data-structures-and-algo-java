package com.scaler.core.java_3_advance_2.dsa_20_hashing_2;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Number_of_Distinct_Points {
    /**
     * Given N 2D points. Calculate the number of distinct points
     * **/
    private static int create2DPoint(int[] A, int[] B, int N) {
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String p = A[i] + "@" + B[i];
            hs.add(p);
        }
        return hs.size();
    }
    public static void main(String[] args) {
        int[] A = {2, 3, 2, 5, 3};
        int[] B = {3, 6, 3, 7, 6};
        int N = A.length;
        int result = create2DPoint(A, B, N);
        PrintUtils.print(result);
    }
}
