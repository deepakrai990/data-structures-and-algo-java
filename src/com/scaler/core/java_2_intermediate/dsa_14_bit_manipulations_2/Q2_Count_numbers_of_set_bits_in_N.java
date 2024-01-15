package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class Q2_Count_numbers_of_set_bits_in_N {
    /**
     * Problem: Count the number of set bits in N.
     * **/
    private static int countSetBit(int N, int lengthOfBinary) {
        int ans = 0;
        for (int i = 0; i < lengthOfBinary; i++) {
            if (checkBit(N, i)) {
                ans++;
            }
        }
        return ans;
    }
    private static boolean checkBit(int N, int i) {
        return ((N >> i) & 1) == 1;
    }
    private static int countSetBit1(int N, int lengthOfBinary) {
        int ans = 0;
        for (int i = 0; i < lengthOfBinary; i++) {
            if (checkBit1(N, i)) {
                ans++;
            }
        }
        return ans;
    }
    private static boolean checkBit1(int N, int i) {
        return (N & (1 << i)) == (1 << i);
    }
    public static void main(String[] args) {
        int N = 45;
        int lengthOfBinary = Integer.toBinaryString(N).length();

        int result = countSetBit(N, lengthOfBinary);
        PrintUtils.print(result);

        result = countSetBit1(N, lengthOfBinary);
        PrintUtils.print(result);
    }
}
