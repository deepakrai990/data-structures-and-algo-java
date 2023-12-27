package com.scaler.core.java_3_advance_3.dsa_39_heaps_1.assignment;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @created 02/04/23 11:27 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Magician_and_Chocolates {

    public int nchoc(int A, int[] B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < B.length; i++) {
            pq.offer(B[i]);
        }
        for (int i = 1; i <= A; i++) {
            int max_val = pq.poll();
            sum = sum % mod + max_val % mod;
            pq.offer((int) Math.floor(max_val / 2));
        }
        return sum % mod;
    }
}
