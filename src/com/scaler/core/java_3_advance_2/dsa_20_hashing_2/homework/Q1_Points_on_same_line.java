package com.scaler.core.java_3_advance_2.dsa_20_hashing_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 02/04/23 7:05 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Points_on_same_line {
    private static int solve(int[] A, int[] B) {
        int ans = 2;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < A.length; j++) {
                int x2 = A[j], y2 = B[j];
                if (x2 == A[i] && y2 == B[i]) {
                    count++;
                    continue;
                }
                String s = slope(A[i], B[i], x2, y2);
                map.put(s, map.getOrDefault(s, 1) + 1);
            }
            for (String s : map.keySet()) {
                int temp = 0;
                temp = Math.max(temp, map.get(s) + count);
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }
    private static String slope(int x1, int y1, int x2, int y2) {
        int X = x2 - x1, Y = y2 - y1;
        int hcf = gcd(X, Y);
        if (hcf != 0) {
            X /= hcf;
            Y /= hcf;
        }
        String s = X + "/" + Y;
        return s;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] A = {-1, 0, 1, 2, 3, 3};
        int[] B = {1, 0, 1, 2, 3, 4};
        int result = solve(A, B);
        PrintUtils.print(result);
    }
}
