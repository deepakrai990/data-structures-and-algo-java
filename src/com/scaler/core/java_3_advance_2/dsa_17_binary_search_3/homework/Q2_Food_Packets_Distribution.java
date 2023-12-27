package com.scaler.core.java_3_advance_2.dsa_17_binary_search_3.homework;

/**
 * @created 02/04/23 7:18 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Food_Packets_Distribution {
    private static int solve(int[] A, int B) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            right = Math.min(right, A[i]);
        }
        int ans = 0;

        while (left <= right) {   //Range 1 to Min number of persons in a city
            int mid = (left + right) / 2;
            if (check(mid, A, B)) {         //check function call
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static boolean check(int m, int A[], int B) {  //check Function
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count = count + A[i] / m;
        }
        if (count >= B) {
            return true;
        }
        return false;
    }
}
