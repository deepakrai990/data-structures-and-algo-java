package com.scaler.core.java_3_advance_2.dsa_18_two_pointers.homework;

import java.util.Arrays;

/**
 * @created 02/04/23 7:13 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q5_3_Sum {
    private static int threeSumClosest1(int[] A, int B) {
        int n = A.length;
        //base case
        if (n <= 3) {
            int sum = 0;
            for (int a : A)
                sum += a;
            return sum;
        }

        long closestSum = Integer.MAX_VALUE;
        Arrays.sort(A); // as an input array is not sorted
        int i = 0; // first pointer

        for (i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            if (i > 0 && A[i] == A[i - 1]) //escaping repeated values of i
                continue;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];

                if (Math.abs(B - sum) < Math.abs(B - closestSum))
                    closestSum = sum;

                if (sum < B)
                    j++;
                else
                    k--;
            }
        }
        return (int) closestSum;
    }

    private static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        long closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int p1 = i + 1;
            int p2 = A.length - 1;
            while (p1 < p2) {
                int sum = A[i] + A[p1] + A[p2];
                if (Math.abs(B - sum) < Math.abs(B - closestSum)) {
                    closestSum = sum;
                }
                if (sum > B) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }
        return (int) closestSum;
    }
}
