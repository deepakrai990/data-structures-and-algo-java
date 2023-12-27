package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_15_searching_1_binary_search_on_array;

/**
 * @created 06/02/23 6:01 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Given a sorted array A[N]. Search if K is present or not?
     * Input 1
     * A[10] = {3, 6, 9, 12, 14, 19, 20, 23, 25, 27}
     * K = 12
     * Input 2
     * A[10] = {3, 6, 9, 12, 14, 19, 20, 23, 25, 27}
     * K = 21
     * <p></p>
     * T.C: O(log base 2 n)
     * S.C: O(1)
     * **/
    private static boolean search(int[] A, int K) {
        int n = A.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == K) {
                return true;
            } else if (A[mid] < K) {
                low = mid + 1;
            } else if (A[mid] > K) {
                high = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] A = {3, 6, 9, 12, 14, 19, 20, 23, 25, 27};
        int K = 12;
        boolean result = search(A, K);
        System.out.printf("%s%5b", "Result: ", result);
    }
}
