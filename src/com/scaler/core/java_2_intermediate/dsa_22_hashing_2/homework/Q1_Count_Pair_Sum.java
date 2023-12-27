package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 20/02/23 8:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Count_Pair_Sum {
    private static int solve(int[] A, int B) {
        int n = A.length;
        int m = 1000000007;
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int b = B - A[i];
            if (hm.containsKey(b)) {
                count = (count + hm.get(b)) % m;
            }
            if (hm.containsKey(A[i])) {
                hm.put(A[i], hm.get(A[i]) + 1);
            } else {
                hm.put(A[i], 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2};
        int B = 3;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
