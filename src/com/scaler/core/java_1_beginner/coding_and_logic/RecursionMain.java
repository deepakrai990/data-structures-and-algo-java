package com.scaler.core.java_1_beginner.coding_and_logic;

/**
 * @created 21/07/22 7:41 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class RecursionMain {
    public static void main(String[] args) {
        int result = foo(3, 5);
        System.out.println(result);
    }

    private static int bar(int x, int y) {
        if (y == 0)
            return 0;
        return (x + bar(x, y -1));
    }

    private static int foo(int x, int y) {
        if (y == 0)
            return 1;
        return bar(x, foo(x, y - 1));
    }
}
