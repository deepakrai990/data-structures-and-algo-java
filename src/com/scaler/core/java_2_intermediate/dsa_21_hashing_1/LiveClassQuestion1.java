package com.scaler.core.java_2_intermediate.dsa_21_hashing_1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @created 06/10/22 11:13 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    private static int[] solve(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if(hm.containsKey(A[i])) {
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
                //System.out.println(hm.get(B[i]));
                queries[i] = hm.get(B[i]);
            } else {
                queries[i] = 0;
            }
        }
        return  queries;
    }
    public static void main(String[] args) {
        int[] A = {2, 5, 9, 2, 8};
        int[] B = {3, 2};
        int[] results = solve(A, B);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
