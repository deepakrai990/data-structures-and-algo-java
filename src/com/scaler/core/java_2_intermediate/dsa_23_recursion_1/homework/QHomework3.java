package com.scaler.core.java_2_intermediate.dsa_23_recursion_1.homework;

/**
 * @created 11/10/22 1:10 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int bar(int x, int y) {
        if (y == 0) return 0;
        return (x + bar(x, y - 1));
    }
    private static int foo(int x, int y) {
        if (y == 0) {
            return 1;
        }
        return bar(x, foo(x, y - 1));
    }
    public static void main(String[] args) {
        System.out.println(foo(3, 5));
    }
}
