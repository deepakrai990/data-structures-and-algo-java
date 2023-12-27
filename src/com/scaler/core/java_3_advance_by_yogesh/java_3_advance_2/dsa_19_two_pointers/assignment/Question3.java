package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_19_two_pointers.assignment;

/**
 * @created 14/02/23 11:08 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static int maxArea(int[] A) {
        int N = A.length;
        if (N == 1) {
            return 0;
        }
        int P1 = 0;
        int p2 = N - 1;
        int ans = Integer.MIN_VALUE;

        while (P1 < p2) {
            int height = Math.min(A[P1], A[p2]);
            int width = p2 - P1;
            int maxWater = height * width;
            if (maxWater > ans) {
                ans = maxWater;
            }
            if (A[P1] < A[p2]) {
                P1++;
            } else {
                p2--;
            }

        }
        return ans;
    }

    public int maxArea1(int[] A) {
        int len = A.length;
        int p1 = 0;
        int p2 = len - 1;
        int ans = 0;
        // edge case condition if array contains only 1 element
        if (len == 1) {
            return 0;
        }
        while (p1 < p2) {
            /*
              The maximum height of the container would be minimum of height at 2 pointers
              **/
            int height = Math.min(A[p1], A[p2]);
            int width = p2 - p1;
            int capacity = height * width;
            if (capacity > ans) {
                ans = capacity; // updating answer whenever getting better capacity
            }
            /*
              As there will not be better capacity with given set
              of minimum height, we need to move that pointer
              **/
            if (height == A[p1]) {
                p1++;
            } else if (height == A[p2]) {
                p2--;
            }
        }
        return ans;
    }
}
