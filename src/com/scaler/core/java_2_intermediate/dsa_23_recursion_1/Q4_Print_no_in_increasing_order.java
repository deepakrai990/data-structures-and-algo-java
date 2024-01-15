package com.scaler.core.java_2_intermediate.dsa_23_recursion_1;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q4_Print_no_in_increasing_order {
    private static void printIncreasingOrder(int N) {
        // Base case
        if (N == 1) {
            System.out.println(1);
            return;
        }
        printIncreasingOrder(N - 1);
        System.out.println(N);
    }

    public static void main(String[] args) {
        int N = 10;
        printIncreasingOrder(N);
    }
}
