package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_18_searching_3_binary_search_on_answer.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 5:07 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int paint(int A, int B, int[] C) {
        int len = C.length;
        int lo = C[0];
        int sum = C[0];
        //To find low and high value of serach space.Painters can't take lower than highest boear size which is max of C[]
        for (int i = 1; i < len; i++) {
            if (C[i] > lo) {
                lo = C[i];
            }
            sum = sum + C[i];
        }
        int hi = sum;
        long ans = hi;
        int mod = 10000003;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if ((check(mid, C, len, A)) == true) {
                ans = (mid * (long) B) % mod; // as each worker would take B time to paint a board.
                hi = (mid - 1);
            } else {
                lo = (mid + 1);
            }
        }
        return (int) (ans % mod);

    }

    private static boolean check(int total, int A[], int N, int K) {
        int w = 1;
        int time = 0;
        // time for each painter for each block
        for (int i = 0; i < N; i++) {
            time = time + A[i];
            if (time > total) {
                w++;
                time = A[i];
            }
        }
        if (w > K) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 5;
        int[] C = {1, 10};
        int result = paint(A, B, C);
        PrintUtils.printInt(result);
    }
}
