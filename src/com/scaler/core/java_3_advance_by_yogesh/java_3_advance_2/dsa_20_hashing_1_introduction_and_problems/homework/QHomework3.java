package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_20_hashing_1_introduction_and_problems.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;

/**
 * @created 16/02/23 10:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    /**
     * Java Solution O(n) - Two Pointer - HashSet - Count Sub-arrays
     **/
    private static int solve(int[] A) {
        int left = 0;
        int right = 0;
        int size = A.length;
        int mod = 1000000007;
        int res = 0;
        HashSet<Integer> set = new HashSet<>();

        while (right < size) {
            if (!set.contains(A[right])) {
                set.add(A[right]);
                res = ((res % mod) + (right - left + 1) % mod) % mod;
                right++;
            } else {
                while (A[left] != A[right]) {
                    set.remove(A[left]);
                    left++;
                }
                set.remove(A[left]);
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
