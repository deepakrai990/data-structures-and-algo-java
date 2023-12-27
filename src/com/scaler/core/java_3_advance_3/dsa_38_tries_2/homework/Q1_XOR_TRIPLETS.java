package com.scaler.core.java_3_advance_3.dsa_38_tries_2.homework;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @created 02/04/23 12:36 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_XOR_TRIPLETS {
    public int solve(int[] A) {
        int n = A.length;
        //If integer i is 0
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap();
        hm.put(0, new ArrayList<>());
        hm.get(0).add(-1);
        long res = 0;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ A[i];
            if (hm.containsKey(xor)) {
                for (int idx : hm.get(xor)) {
                    res += (i - idx - 1);
                }
                hm.get(xor).add(i);
            } else {
                hm.put(xor, new ArrayList<>());
                hm.get(xor).add(i);
            }
        }
        int p = (1000 * 1000 * 1000) + 7;
        return (int) (res % p);
    }
}
