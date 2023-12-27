package com.scaler.core.java_3_advance_1.dsa_01_arrays_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:10 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Continuous_Sum_Query {
    private static int[] solve(int A, int[][] B) {
        int[] beggars = new int[A];
        int size = B.length;
        for (int i = 0; i < size; i++) {
            int l = B[i][0] - 1; //making indexes 0 based
            int r = B[i][1]; //need to add -(money) at r+1 index, already 1 based indexing
            int money = B[i][2];

            beggars[l] += money;
            if (r < A)
                beggars[r] += (money * -1); // to compensate with prefix sum
        }
        for (int i = 1; i < A; i++) {
            beggars[i] = beggars[i - 1] + beggars[i]; // calculating the prefix sum
        }
        return beggars;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] results = solve(A, B);
        PrintUtils.print(results);
    }
}
