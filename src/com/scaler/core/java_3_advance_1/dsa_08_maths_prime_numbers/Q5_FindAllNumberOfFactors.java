package com.scaler.core.java_3_advance_1.dsa_08_maths_prime_numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 19/09/23 12:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_FindAllNumberOfFactors {
    private static void findAllNumberOfFactors(int n) {
        int[] spfArray = spf(n);
        for (int i = 1; i <= n; i++) {
            Map<Integer, Integer> spfMap = createSpfMap(i, spfArray);
            int ans = 1;
            for (int k: spfMap.keySet()) {
                // Add 1 to calculate power
                int power = spfMap.get(k) + 1;
                ans = ans * power;
            }
            System.out.println("Number : [" + i + "], Factors : [" + ans + "]" );
        }
    }
    private static int[] spf(int n) {
        int[] spf = new int[n + 1];
        for (int i = 0; i <= n; i++) spf[i] = i;
        spf[0] = spf[1] = 1;
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }

    private static Map<Integer, Integer> createSpfMap(int x, int[] spf) {
        Map<Integer, Integer> spfMap = new HashMap<>();
        while (x > 1) {
            if (spfMap.containsKey(spf[x])) {
                spfMap.put(spf[x], spfMap.get(spf[x]) + 1);
            } else {
                spfMap.put(spf[x], 1);
            }
            x = x / spf[x];
        }
        return spfMap;
    }

    public static void main(String[] args) {
        int n = 100;
        findAllNumberOfFactors(n);
    }
}
