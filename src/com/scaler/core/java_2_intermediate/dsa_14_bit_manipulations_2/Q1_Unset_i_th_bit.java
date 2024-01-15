package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2;

/**
 * @created 23/09/22 5:54 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Unset_i_th_bit {
    private static int unSetIthBit1(int N, int i) {
        if (checkBit1(N, i)) {
            N = N ^ (1 << i);
        }
        return N;
    }
    private static boolean checkBit1(int N, int i) {
        return (N & (1 << i)) == (1 << i);
    }
    private static int unSetIthBit2(int N, int i) {
        if (checkBit2(N, i)) {
            N = N ^ (1 << i);
        }
        return N;
    }
    private static boolean checkBit2(int N, int i) {
        return (N | (1 << i)) == N;
    }
    private static int unSetIthBit3(int N, int i) {
        if (checkBit3(N, i)) {
            N = N ^ (1 << i);
        }
        return N;
    }
    private static boolean checkBit3(int N, int i) {
        return (N ^ (1 << i)) < N;
    }
    private static int unSetIthBit4(int N, int i) {
        if (checkBit4(N, i)) {
            N = N ^ (1 << i);
        }
        return N;
    }
    private static boolean checkBit4(int N, int i) {
        return ((N >> i) & 1) == 1;
    }
    public static void main(String[] args) {
        int N = 45;
        int i = 2; // ith bit
        System.out.println("Binary number of " + N + " is : " + Integer.toBinaryString(N));
        int result = unSetIthBit1(N, i);
        System.out.println("Binary number after unset " + i +"th bit " + result + " is :  "
                + Integer.toBinaryString(result));
        System.out.println("-------------------------------");
        System.out.println("Binary number of " + N + " is : " + Integer.toBinaryString(N));
        result = unSetIthBit2(N, i);
        System.out.println("Binary number after unset " + i +"th bit " + result + " is :  "
                + Integer.toBinaryString(result));
        System.out.println("-------------------------------");
        System.out.println("Binary number of " + N + " is : " + Integer.toBinaryString(N));
        result = unSetIthBit3(N, i);
        System.out.println("Binary number after unset " + i +"th bit " + result + " is :  "
                + Integer.toBinaryString(result));
        System.out.println("-------------------------------");
        System.out.println("Binary number of " + N + " is : " + Integer.toBinaryString(N));
        result = unSetIthBit4(N, i);
        System.out.println("Binary number after unset " + i +"th bit " + result + " is :  "
                + Integer.toBinaryString(result));
    }
}
