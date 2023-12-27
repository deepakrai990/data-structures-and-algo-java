package com.scaler.core.java_3_advance_2.dsa_20_hashing_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @created 02/04/23 7:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Common_Elements {
    private static int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        // Counting freq of each element A
        for (int i : A) {
            if (freq.containsKey(i)) {
                int increment = freq.get(i) + 1;
                freq.put(i, increment);
            } else freq.put(i, 1);
        }
        // Counting the similar in B
        for (int i : B) {
            if (freq.containsKey(i) && freq.get(i) > 0) {
                arr.add(i);
                int decre = freq.get(i) - 1;
                freq.put(i, decre);
            }
        }
        int[] res = new int[arr.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = arr.get(i);
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 1};
        int[] B = {2, 3, 1, 2};
        int[] results = solve(A, B);
        PrintUtils.print(results);
    }
}
