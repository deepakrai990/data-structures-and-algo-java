package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @created 02/04/23 10:23 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Fibonacci_Number {
    private static List<Integer> A = new ArrayList<>(Arrays.asList(0, 1));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(fib(n));
        sc.close();
    }

    private static int fib(int n) {
        for (int i = 2; i <= n; i++) A.add(A.get(i - 1) + A.get(i - 2));
        return A.get(n);
    }
}
