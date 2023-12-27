package com.scaler.core.java_3_advance_2.dsa_18_two_pointers.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @created 02/04/23 7:10 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_3_Sum_Zero {
    private static int[][] threeSum(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        HashSet<List<Integer>> hashset = new HashSet<>();
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int target = -A[i];
            int start = i + 1, end = n - 1;

            while (start < end) {
                int sum = A[start] + A[end];

                if (sum == target) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(A[i]);
                    arr.add(A[start++]);
                    arr.add(A[end--]);

                    if (!hashset.contains(arr)) {
                        hashset.add(arr);
                        res.add(arr.stream().mapToInt(Integer::intValue).toArray());
                    }
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        int outSize = res.size();
        int[][] out = new int[outSize][3];

        for (int i = 0; i < outSize; i++) {
            out[i] = res.get(i);
        }
        return out;
    }
}
