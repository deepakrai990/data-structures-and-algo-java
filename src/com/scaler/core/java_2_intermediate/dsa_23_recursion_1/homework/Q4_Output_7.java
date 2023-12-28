package com.scaler.core.java_2_intermediate.dsa_23_recursion_1.homework;

/**
 * @created 11/10/22 1:14 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q4_Output_7 {
    private static int fun(int x, int n) {
        if (n == 0) return 1;
        else if (n % 2 == 0)
            return fun(x * x, n / 2);
        else
            return x * fun(x * x, (n - 1) / 2);
    }
    public static void main(String[] args) {
        int ans = fun(2, 10);
        System.out.println("Ans : " + ans);
    }
}
