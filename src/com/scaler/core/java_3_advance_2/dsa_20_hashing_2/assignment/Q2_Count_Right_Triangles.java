package com.scaler.core.java_3_advance_2.dsa_20_hashing_2.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 02/04/23 7:02 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Count_Right_Triangles {
    private static int solve(int[] A, int[] B) {
        int N = A.length;
        int mod = 1000000000 + 7;
        //Creating frequency Map to store x and y coordinates in two hashmaps
        HashMap<Integer, Integer> freqX = new HashMap<>();
        HashMap<Integer, Integer> freqY = new HashMap<>();
        for (int i = 0; i < N; i++) {
            //adding x to freq map
            if (!freqX.containsKey(A[i])) {
                freqX.put(A[i], 1);
            } else {
                freqX.put(A[i], freqX.get(A[i]) + 1);
            }
            // adding y coordinates to freqY map
            if (!freqY.containsKey(B[i])) {
                freqY.put(B[i], 1);
            } else {
                freqY.put(B[i], freqY.get(B[i]) + 1);
            }
        }
        long ans = 0;
        for (int i = 0; i < N; i++) {

            long countx = freqX.get(A[i]);
            long county = freqY.get(B[i]);

            ans = ans + (countx - 1) * (county - 1);
        }
        return (int) ans % mod;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 3, 3};
        int[] B = {1, 2, 1, 2, 1};
        int result = solve(A, B);
        PrintUtils.print(result);
    }
}
