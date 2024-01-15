package com.scaler.core.java_3_advance_1.dsa_04_bit_manipulations_1;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Check_i_th_bit_set_or_not {
    private static boolean checkBit1(int N, int i) {
        // Using AND operator with left shift
        return (N & (1 << i)) == (1 << i);
    }
    private static boolean checkBit2(int N, int i) {
        // Using OR operator with left shift
        return (N | (1 << i)) == N;
    }
    private static boolean checkBit3(int N, int i) {
        // Using XOR operator with left shift
        return (N ^ (1 << i)) < N;
    }
    private static boolean checkBit4(int N, int i) {
        // Using right shift operator with AND 1
        return ((N >> i) & 1) == 1;
    }
    public static void main(String[] args) {
        int N = 29;
        int i = 2;

        boolean result = checkBit1(N, i);
        System.out.println(i +"th bit of " + N + " is " + (result ? "set" : "unset"));

        result = checkBit2(N, i);
        System.out.println(i +"th bit of " + N + " is " + (result ? "set" : "unset"));

        result = checkBit3(N, i);
        System.out.println(i +"th bit of " + N + " is " + (result ? "set" : "unset"));

        result = checkBit4(N, i);
        System.out.println(i +"th bit of " + N + " is " + (result ? "set" : "unset"));
    }
}
