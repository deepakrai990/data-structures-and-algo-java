package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1;

import java.util.Arrays;

/**
 * @created 04/01/23 7:26 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {
    /**
     * Create Prefix Max and Suffix Max
     **/
    private static int[] preparePrefixMax(int[] A) {
        int n = A.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(A[i], prefixMax[i - 1]);
        }
        return prefixMax;
    }

    private static int[] prepareSuffixMax(int[] A) {
        int n = A.length;
        int[] prefixMax = new int[n];
        prefixMax[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefixMax[i] = Math.max(A[i], prefixMax[i + 1]);
        }
        return prefixMax;
    }

    public static void main(String[] args) {
        int[] A = {1, -6, 3, 2, 8, 7};
        System.out.println("------------------Prefix Max------------------");
        int[] results = preparePrefixMax(A);
        System.out.println(Arrays.toString(results));
        System.out.println("------------------Suffix Max------------------");
        int[] A1 = {3, 10, 6, 7, 0, 2, -1};
        int[] results1 = prepareSuffixMax(A1);
        System.out.println(Arrays.toString(results1));
    }


}
