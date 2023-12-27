package com.scaler.core.java_2_intermediate.dsa_21_hashing_1.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 20/02/23 4:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int[] solve(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hm.containsKey(A[i])) {
                Integer value = hm.get(A[i]);
                value++;
                hm.replace(A[i], value);
            } else {
                hm.put(A[i], 1);
            }
        }

        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            if (hm.containsKey(B[i])) {
                queries[i] = hm.get(B[i]);
            } else {
                queries[i] = 0;
            }
        }
        return queries;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 1};
        int[] B = {1, 2};
        int[] results = solve(A, B);
        PrintUtils.print1DArray(results);
    }
}
