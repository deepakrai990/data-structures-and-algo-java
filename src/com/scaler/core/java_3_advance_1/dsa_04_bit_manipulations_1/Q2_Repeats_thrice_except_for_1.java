package com.scaler.core.java_3_advance_1.dsa_04_bit_manipulations_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 13/01/24
 * @project scaler_course_code
 */
public class Q2_Repeats_thrice_except_for_1 {
    /**
     * Problem: Given an array A[N]. Every element repeats thrice except for one unique element.
     * **/
    // Approach 1
    private static int repeatThrice(int[] A) {
        int N = A.length;
        int ans = 0;
        for (int i = 0; i <= 30; i++) {
            // For ith bit, get the number of set bits
            int c = 0;
            for (int j = 0; j < N; j++) {
                if (checkBit(A[j], i)) {
                    c++;
                }
            }
            if (c % 3 == 1) {
                ans = ans + (1 << i); // (2)^i
            }
        }
        return ans;
    }
    private static boolean checkBit(int N, int I) {
        return (N & (1 << I)) == (1 << I);
    }

    // Approach 2 Function to find the unique element in the array where every element repeats thrice
    private static int findUniqueElement(int[] A) {
        int n = A.length;
        int[] count = new int[32]; // Assuming integers are 32 bits
        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            int num = A[i];
            // Update the count array for each bit position
            for (int j = 0; j < 32; j++) {
                if ((num & (1 << j)) != 0) {
                    count[j]++;
                }
            }
        }
        int result = 0;
        // Reconstruct the unique element based on the count array
        for (int i = 0; i < 32; i++) {
            count[i] %= 3; // Take modulo to ensure counts are multiples of 3
            result |= (count[i] << i); // Reconstruct the unique element
        }
        return result;
    }
    public static void main(String[] args) {
        int[] A = {5, 7, 5, 4, 7, 11, 11, 9, 11, 7, 5, 4, 4};

        int result = repeatThrice(A);
        PrintUtils.print(result);

        result = findUniqueElement(A);
        PrintUtils.print(result);
    }
}
