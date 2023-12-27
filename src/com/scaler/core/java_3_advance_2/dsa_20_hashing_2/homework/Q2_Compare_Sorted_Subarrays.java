package com.scaler.core.java_3_advance_2.dsa_20_hashing_2.homework;

import java.util.HashMap;

/**
 * @created 02/04/23 7:05 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Compare_Sorted_Subarrays {
    private static int[] solve(int[] A, int[][] B) {
        HashMap<Integer, Long> hashMap = generateHashes(A);
        int n = A.length;
        long[] pfsum = new long[n];
        pfsum[0] = hashMap.get(A[0]);

        for (int i = 1; i < n; i++) {
            pfsum[i] = pfsum[i - 1] + hashMap.get(A[i]);
        }

        int qLen = B.length;
        int out[] = new int[qLen];
        int q = 0;

        while (q < qLen) {
            int l1 = B[q][0], r1 = B[q][1];
            int l2 = B[q][2], r2 = B[q][3];
            long segment1 = l1 > 0 ? pfsum[r1] - pfsum[l1 - 1] : pfsum[r1];
            long segment2 = l2 > 0 ? pfsum[r2] - pfsum[l2 - 1] : pfsum[r2];
            out[q] = (segment1 == segment2) ? 1 : 0;
            q++;
        }
        return out;
    }

    private static HashMap<Integer, Long> generateHashes(int[] A) {
        HashMap<Integer, Long> hashMap = new HashMap();
        for (int i : A) {
            if (!hashMap.containsKey(i)) {
                long hashValue = generateHash(i);
                hashMap.put(i, hashValue);
            }
        }
        return hashMap;
    }

    private static long generateHash(int val) {
        long largeNum = (long) Math.pow(10, 13);
        return (long) ((largeNum * Math.random()) + val);
    }
}
