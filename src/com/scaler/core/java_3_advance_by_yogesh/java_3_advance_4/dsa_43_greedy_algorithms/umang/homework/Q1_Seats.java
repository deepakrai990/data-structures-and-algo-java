package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_4.dsa_43_greedy_algorithms.umang.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @created 31/03/23 11:38 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Seats {
    private static int seats(String A) {
        int n = A.length();
        int mod = 10000003;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'x')
                list.add(i);
        }
        if (list.isEmpty()) return 0;

        int m = list.size();
        int mid = m / 2;
        int l = mid - 1, r = mid + 1, k = 1;
        long res = 0;

        while (l >= 0) {
            res = (res + list.get(mid) - k - list.get(l)) % mod;
            l--;
            k++;
        }

        k = 1;
        while (r < m) {
            res = (res + list.get(r) - list.get(mid) - k) % mod;
            r++;
            k++;
        }

        return (int) res % mod;
    }

    public static void main(String[] args) {
        String A = "....x..xx...x..";
        int result = seats(A);
        PrintUtils.print(result);
    }
}
