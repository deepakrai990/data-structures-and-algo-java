package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 20/02/23 8:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int[] dNums(int[] A, int B) {
        int[] ans = new int[A.length - B + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < B; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        ans[0] = map.size();
        int k = 1;

        for (int i = B; i < A.length; i++) {
            if (map.get(A[i - B]) == 1) {
                map.remove(A[i - B]);
            } else {
                map.put(A[i - B], map.get(A[i - B]) - 1);
            }
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
            ans[k++] = map.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        int[] results = dNums(A, B);
        PrintUtils.print1DArray(results);
    }
}
