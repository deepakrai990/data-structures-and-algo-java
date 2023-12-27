package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_20_hashing_1_introduction_and_problems;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 16/02/23 9:46 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Question 1: Closest Duplicates
     * Given an integer array of size N. Find pair (i, j) such that j > i and
     * A[i] == A[j] && j - i is minimum.
     * Example
     * int[] A = {2, 4, 5, 6, -1, 2, 5, 4, 3, 7, 3, 2};
     * T.C: O(N)
     * S.C: O(N)
     * **/
    private static int findMinDistanceOfClosestDuplicates(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int k = A[i];
            if (!map.containsKey(k)) {
                map.put(k, i);
            } else {
                int lastOccurrence = map.get(k);
                ans = Math.min(ans, i - lastOccurrence);
                map.put(k, i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {2, 4, 5, 6, -1, 2, 5, 4, 3, 7, 3, 2};
        int result = findMinDistanceOfClosestDuplicates(A);
        PrintUtils.printInt(result);
    }
}
