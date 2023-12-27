package com.scaler.core.java_3_advance_2.dsa_18_two_pointers.homework;

/**
 * @created 02/04/23 7:13 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q6_Another_Count_Rectangles {
    private static int solve(int[] A, int B) {
        int ans = 0;
        // int mod = 1000000007;
        int mod = (int) (Math.pow(10, 9)) + 7;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < Math.sqrt(B))
                ans++;
        }
        int p1 = 0, p2 = A.length - 1;
        int countPairs = 0;
        while (p1 < p2) {
            if (1l * A[p1] * A[p2] >= B) {
                p2--;
            } else {
                countPairs += p2 - p1;
                p1++;
                countPairs %= mod;
            }
        }
        ans += (countPairs * 2) % mod;
        return ans;
    }
}
