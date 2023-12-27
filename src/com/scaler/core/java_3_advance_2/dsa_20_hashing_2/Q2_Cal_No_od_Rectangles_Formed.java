package com.scaler.core.java_3_advance_2.dsa_20_hashing_2;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @created 04/10/23 7:40 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Cal_No_od_Rectangles_Formed {
    /**
     * Given N distinct points. Calculate the number of rectangles formed,
     * such that sides are parallel to x-axis and y-axis.
     * **/
    private static int countRectangles(int[] X, int[] Y) {
        int N = X.length, result = 0;
        Set<String> hs = create2DPoint(X, Y, N);
        for (int i = 0; i < N; i++) { //(X, Y)
            for (int j = i + 1; j < N; j++) { // (p, q)
                int a = X[i], b = Y[i], p = X[j], q = Y[j];
                if (a != p && b != q) {
                    String p1 = a + "@" + q;
                    String p2 = p + "@" + b;
                    if (hs.contains(p1) && hs.contains(p2)) {
                        result++;
                    }
                }
            }
        }
        return result / 2;
    }
    private static Set<String> create2DPoint(int[] X, int[] Y, int N) {
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String p = X[i] + "@" + Y[i];
            hs.add(p);
        }
        return hs;
    }
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 6, 5, 3, 1};
        int[] B = {3, 3, 3, 3, 1, 1, 1};
        int result = countRectangles(A, B);
        PrintUtils.print(result);
    }
}
