package com.scaler.core.java_2_intermediate.dsa_21_hashing_1.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 20/02/23 4:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Count_unique_elements {
    private static int solve(int[] A) {
        int n = A.length;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (freq.containsKey(A[i])) {
                Integer value = freq.get(A[i]);
                value++;
                freq.replace(A[i], value);
            } else {
                freq.put(A[i], 1);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (freq.get(A[i]) == 1)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {3, 3, 3, 9, 0, 1, 0};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
