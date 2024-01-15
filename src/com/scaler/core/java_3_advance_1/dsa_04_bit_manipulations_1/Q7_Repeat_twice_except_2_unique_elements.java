package com.scaler.core.java_3_advance_1.dsa_04_bit_manipulations_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 13/01/24
 * @project scaler_course_code
 */
public class Q7_Repeat_twice_except_2_unique_elements {
    /**
     * Given an array A[N]. Every element repeats twice, except two unique elements.
     * Find the two unique elements
     * **/
    private static int[] findTwoUniqueElements(int[] A) {
        int N = A.length, value = 0;
        // Step 1: Take XOR of the whole array
        for (int i = 0; i < N; i++) {
            value = value ^ A[i];
        }
        // Step 2: Find any set bit position in value
        int position = Integer.MIN_VALUE;
        for (int i = 0; i <= 30; i++) {
            if (checkBit(value, i)) {
                position = i;
                break;
            }
        }
        // Step 3: Split array based on position into set & unset bit positions
        int set = 0, unset = 0;
        for (int i = 0; i < N; i++) {
            if (checkBit(A[i], position)) {
                set = set ^ A[i];
            } else {
                unset = unset ^ A[i];
            }
        }
        return new int[]{set, unset};
    }
    private static boolean checkBit(int N, int I) {
        return (N & (1 << I)) == (1 << I);
    }
    // Function to find the two unique elements in the array
    private static void findTwoUniqueElements1(int[] A) {
        int n = A.length;
        // XOR all elements to get the XOR result of the two unique elements
        int xorResult = 0;
        for (int i = 0; i < n; i++) {
            xorResult ^= A[i];
        }
        // Find the rightmost set bit in the XOR result
        int differingBit = xorResult & -xorResult;
        // Initialize variables to store the two unique elements
        int uniqueElement1 = 0;
        int uniqueElement2 = 0;
        // Partition the array into two groups based on the differing bit
        for (int i = 0; i < n; i++) {
            if ((A[i] & differingBit) == 0) {
                // Group with the rightmost set bit isn't set
                uniqueElement1 ^= A[i];
            } else {
                // Group with the rightmost set bit set
                uniqueElement2 ^= A[i];
            }
        }
        // Output the two unique elements
        System.out.println("Two Unique Elements: " + uniqueElement1 + " and " + uniqueElement2);
    }
    public static void main(String[] args) {
        int[] A = {10, 8, 8, 9, 12, 9, 6, 11, 10, 6, 12, 17};

        int[] results = findTwoUniqueElements(A);
        PrintUtils.print(results);

        findTwoUniqueElements1(A);
    }
}
