package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.homework;

/**
 * @created 21/09/22 3:59 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q2_Interesting_Array {
    private static String solve(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        if ((xor & 1) == 1) return "No";
        return "Yes";
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Hint 1
     * Xor has a property that A XOR A = 0.
     * Can we use this property to check if the answer is possible or not?
     *
     * Solution Approach
     * If any element in the array is even then, it can be made 0. Split that element into two equal parts of A[i]/2
     * and A[i]/2. XOR of two identical numbers is zero. Therefore this strategy makes an element 0.
     *
     * If any element is odd. Split it in two-part: 1, A[i]-1. Since A[i]-1 is even, it can be made 0 by the above
     * strategy. Therefore an odd element can reduce its size to 1.
     *
     * Therefore, two odd elements can be made 0 by following the above strategy and
     * finally XOR them (i.e., 1) as 1 XOR 1 = 0.
     *
     * Therefore if the number of odd elements in the array is even, the answer is possible. Otherwise,
     * an element of value 1 will be left, and it is impossible to satisfy the condition.
     * **/
    private static String solve1(int[] A) {
        int cnt = 0;
        for (int x: A) {
            if (x % 2 == 1)
                cnt++;
        }
        if (cnt % 2 == 1)
            return "No";
        else
            return "Yes";
    }
    public static void main(String[] args) {
        int[] A = {9, 17};
        String result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
