package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_02_arrays_2_two_dimensional.homework;

/**
 * @created 09/02/23 12:37 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int solve(int[] A, int B) {
        int count = 0;
        int N = A.length;

        for (int i = 0; i < N; i++) {
            if (A[i] <= B) count++;
        }

        int rangeCount = 0;
        for (int i = 0; i < count; i++) {
            if (A[i] <= B) rangeCount++;
        }

        int s = 1;
        int e = count;
        int maxRangeCount = rangeCount;
        while (e < N) {
            if (A[s - 1] <= B) rangeCount--;
            if (A[e] <= B) rangeCount++;
            maxRangeCount = Math.max(maxRangeCount, rangeCount);
            s++;
            e++;
        }
        return count - maxRangeCount;
    }

    public static void main(String[] args) {
        int[] A = {1, 12, 10, 3, 14, 10, 5};
        int B = 8;
        int result = solve(A, B);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
