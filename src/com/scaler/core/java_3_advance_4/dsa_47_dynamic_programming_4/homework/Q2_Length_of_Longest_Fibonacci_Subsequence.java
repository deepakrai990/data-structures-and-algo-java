package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4.homework;

import java.util.HashMap;

/**
 * @created 02/04/23 10:12 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Length_of_Longest_Fibonacci_Subsequence {
    private static int solve(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        //need indexes of sum of first and second element using hm for that
        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int maxLength = 0;
            for (int j = i + 1; j < n; j++) {
                int sum = A[i] + A[j];

                int first = i, second = j, length = 2;
                while (map.containsKey(sum)) {
                    length++;
                    first = second;
                    second = map.get(sum);
                    sum = A[first] + A[second];
                }
                if (length > 2)
                    maxLength = Math.max(length, maxLength);
            }
            ans = Math.max(ans, maxLength);
        }
        return ans;
    }
}
