package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays;

/**
 * @created 15/12/22 10:07 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B).
     * Check if any good pair exist or not.
     * **/
    private static int countOfPairs(int[] A, int B, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] + A[j] == B)
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {3, -2, 1, 4, 3, 6, 8};
        int N = A.length;
        int B = 10;
        int result = countOfPairs(A, B, N);
        System.out.printf("%s%10d\n", "Result = ", result);
    }
}
