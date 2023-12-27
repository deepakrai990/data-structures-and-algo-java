package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_08_maths_3_prime_numbers.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @created 11/02/23 7:15 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int solve(int[] A) {
        int max = getMax(A);
        int ans = 0;
        int[] spf = new int[max + 1];
        findSPF(max, spf);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : A) {
            if (i == 1) continue;
            hm.put(spf[i], hm.getOrDefault(spf[i], 0) + 1);
            ans += 1 << hm.get(spf[i]) - 1;
        }
        return ans;
    }

    private static void findSPF(int max, int[] spf) {
        Arrays.fill(spf, 1);
        int pre = 1;
        int x = (int) Math.sqrt(max);
        for (int i = 2; i <= x; i++) {
            if (spf[i] == 1) {
                for (int j = i * i; j <= max; j += i) {
                    spf[j] = 0;
                }
            }
        }
        for (int i = 2; i <= max; i++) {
            if (spf[i] == 1) {
                pre = i;
            }
            spf[i] = pre;
        }
    }

    private static int getMax(int[] A) {
        int N = A.length;
        int max = 1 << 31;
        for (int i : A) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 2, 3};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
