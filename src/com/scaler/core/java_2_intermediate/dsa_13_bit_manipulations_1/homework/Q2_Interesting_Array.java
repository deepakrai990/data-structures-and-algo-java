package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.homework;

/**
 * @author Deepak Kumar Rai
 * @created 21/09/22 3:59 pm
 * @project Scaler_Beginners_Module
 */
public class Q2_Interesting_Array {
    private static String solve(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        if ((xor & 1) == 1) return "No";
        return "Yes";
    }

    private static String solve1(int[] A) {
        int cnt = 0;
        for (int x : A) {
            if (x % 2 == 1)
                cnt++;
        }
        if (cnt % 2 == 1)
            return "No";
        else
            return "Yes";
    }

    public static void main(String[] args) {
        int[] A = {9, 17};
        String result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
