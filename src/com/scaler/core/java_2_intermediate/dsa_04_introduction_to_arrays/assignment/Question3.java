package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.assignment;

import java.util.Arrays;

/**
 * @created 19/09/22 5:02 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Reverse in a range
     * <p>
     * Problem Description
     * Given an array A of N integers. Also given are two integers B and C. Reverse the array A in the
     * given range [B, C]
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <= 109
     * 0 <= B <= C <= N - 1
     * <p>
     * <p>
     * Input Format
     * The first argument A is an array of integer.
     * The second and third arguments are integers B and C
     * <p>
     * <p>
     * Output Format
     * Return the array A after reversing in the given range.
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [1, 2, 3, 4]
     * B = 2
     * C = 3
     * Input 2:
     * <p>
     * A = [2, 5, 6]
     * B = 0
     * C = 2
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * [1, 2, 4, 3]
     * Output 2:
     * <p>
     * [6, 5, 2]
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * We reverse the subarray [3, 4].
     * Explanation 2:
     * <p>
     * We reverse the entire array [2, 5, 6].
     **/
    private static int[] solve(int[] A, int B, int C) {
        int iStart = B;
        int jEnd = C;
        while (iStart < jEnd) {
            int temp = A[iStart];
            A[iStart] = A[jEnd];
            A[jEnd] = temp;
            iStart++;
            jEnd--;
        }
        return A;
    }

    /**
     * Scaler Solution
     * We can initialise two variable i and j with B and C.
     * We will iterate till i < j, swapping A[i] and A[j]
     * in every step and then incrementing i and decrementing j.
     * <p>
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     **/
    private static int[] solve1(int[] A, int B, int C) {
        int i = B, j = C;
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i += 1;
            j -= 1;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int B = 2;
        int C = 3;
        int[] results = solve(A, B, C);
        System.out.println("Results : " + Arrays.toString(results));
        results = solve1(A, B, C);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
