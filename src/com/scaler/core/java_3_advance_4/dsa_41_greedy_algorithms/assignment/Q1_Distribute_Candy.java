package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms.assignment;

/**
 * @created 02/04/23 11:05 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Distribute_Candy {
    private static int candy(int[] A) {
        int n = A.length;
        int[] candies = new int[n];
        int sum = 0;
        //forward direction iteration
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1])
                candies[i] = candies[i - 1] + 1;
        }
        //backward direction iteration
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        for (int candy : candies) {
            sum += candy;
        }
        return sum + n; //one candy to each child
    }
}
