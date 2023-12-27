package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_20_hashing_1_introduction_and_problems.assignment;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @created 16/02/23 10:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    public int solve(int[] A) {
        HashSet<Long> hs = new HashSet();
        if (A.length < 2) {
            if (A[0] == 0)
                return 1;
        }
        long[] pf = new long[A.length];
        pf[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            pf[i] = pf[i - 1] + A[i];
            if (pf[i] == 0)
                return 1;
        }

        for (int i = 0; i < pf.length; i++) {
            if (hs.contains(pf[i]))
                return 1;
            else
                hs.add(pf[i]);
        }
        return 0;
    }
    public int solve1(int[] A) {
        Long pfSum[] = new Long[A.length];
        pfSum[0] = (long) A[0];
        for (int i = 1; i < A.length; i++) {
            pfSum[i] = A[i] + pfSum[i - 1];
        }

        // algo 1 with prefix sum
        HashMap<Long, Integer> mapSum = new HashMap<>();
        for (int i = 0; i < pfSum.length; i++) {
            if (pfSum[i] == 0) {
                return 1;
            }
            if (mapSum.containsKey(pfSum[i])) {
                mapSum.put(pfSum[i], mapSum.get(pfSum[i]) + 1);
            } else {
                mapSum.put(pfSum[i], 1);
            }
        }
        for (long item : mapSum.keySet()) {
            if (mapSum.get(item) > 1) {
                return 1;
            }
        }
        return 0;
    }
        // algo 2 with prefix sum
    public int solve2(int[] A) {
        Long psum[] = new Long[A.length];
        psum[0] = (long) A[0];
        for (int i = 1; i < A.length; i++) {
            psum[i] = A[i] + psum[i - 1];
        }
        HashSet<Long> hset = new HashSet<>();
        for (int i = 0; i < psum.length; i++) {
            if (psum[i] == 0) {
                return 1;
            }
            hset.add(psum[i]);
        }
        if (psum.length == hset.size()) {
            return 0;
        } else {
            return 1;
        }
    }
    // algo 3 with prefix sum
    public int solve3(int[] A) {

        HashSet<Long> hset = new HashSet<>();
        long psum = 0;

        for(int i=0; i<A.length; i++){
            psum += A[i];

            if(psum == 0 || hset.contains(psum)){
                return 1;
            } else {
                hset.add(psum);
            }
        }
        return 0;
    }
}
