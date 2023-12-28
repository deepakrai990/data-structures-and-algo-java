package com.scaler.core.java_2_intermediate.dsa_11_arrays_interview_problems_1.assignment;

/**
 * @created 26/09/22 8:59 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q4_Josephus_Problem_2 {
    private static int solve(int A) {
        int p = 1;
        while (p <= A)
            p *= 2;

        return (2 * A) - p + 1;
    }
    private static int solve1(int A) {
        int position = msbPos(A);
        int j = (int)Math.pow(2, (position - 1));
        A = A - j;
        A = A * 2;
        A = A + 1;
        return A;
    }
    private static int msbPos(int n){
        int pos = 0;
        while (n != 0) {
            pos++;
            n = n / 2;
        }
        return pos;
    }
    public static void main(String[] args) {
        int A = 5;
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);
    }
}
