package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1_one_dimensional.assignment;

/**
 * @created 20/01/23 8:37 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static int maxArr(int[] A) {
        int maxForI = Integer.MIN_VALUE;
        int maxForJ = Integer.MIN_VALUE;
        int minForI = Integer.MAX_VALUE;
        int minForJ = Integer.MAX_VALUE;

        for (int k = 0; k < A.length; k++) {
            maxForI = Math.max(maxForI, A[k] + k);
            minForI = Math.min(minForI, A[k] + k);
            maxForJ = Math.max(maxForJ, A[k] - k);
            minForJ = Math.min(minForJ, A[k] - k);
        }
        return Math.max(maxForI - minForI, maxForJ - minForJ);
    }

    public static void main(String[] args) {
        int[] A = {1, 3, -1};
        int result = maxArr(A);
        System.out.println("Result : " + result);

    }
}
