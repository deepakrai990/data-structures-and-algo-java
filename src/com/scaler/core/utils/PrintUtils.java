package com.scaler.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @created 10/02/23 9:58 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class PrintUtils<T> {
    public static void printInt(int result) {
        System.out.printf("%s%5d", "Result: ", result);
    }

    public static <T> void print(T result) {
        switch (result.getClass().getSimpleName()) {
            case "Integer":
            case "Long":
                printVal(result);
                break;
            case "String":
            case "Boolean":
                printString(result);
                break;
            case "String[]":
                print1DStringArray(result);
                break;
            case "int[]":
                print1DArray(result);
                break;
            case "int[][]":
                print2DArray(result);
                break;
            case "boolean[][]":
                print2DArrayBoolean(result);
                break;
            case "ArrayList":
                printList(result);
                break;
            default:
                System.out.println("\n");
        }
        System.out.println();
    }

    private static <T> void printVal(T result) {
        System.out.printf("%s%5d\n", "Result: ", result);
    }

    public static void printLong(long result) {
        System.out.printf("%s%5d", "Result: ", result);
    }

    public static <T> void print1DArray(T results) {
        System.out.printf("%s%5s", "Results: ", Arrays.toString((int[]) results));
    }

    public static void printCharArr(char[] results) {
        System.out.printf("%s%5s", "Results: ", Arrays.toString(results));
    }

    public static <T> void print1DStringArray(T results) {
        System.out.printf("%s%5s", "Results: ", Arrays.toString( (String[]) results));
    }

    public static <T> void print2DArray(T results) {
        System.out.printf("%s%5s", "Results: ", Arrays.deepToString((int[][]) results));
    }
    public static <T> void print2DArrayBoolean(T results) {
        System.out.printf("%s%5s", "Results: ", Arrays.deepToString((boolean[][]) results));
    }

    public static <T> void printList(T A) {
        if (!((ArrayList<?>) A).isEmpty()) {
            if(((ArrayList<?>) A).get(0).getClass().getSimpleName().equals("ArrayList")) {
                print2DList(A);
            } else {
                System.out.printf("%s%5s", "Results: ", Arrays.toString(((List<?>) A).toArray()));
            }
        }
    }

    public static <T> void print2DList(T A) {
        @SuppressWarnings("unchecked")
        ArrayList<ArrayList<Integer>> values = (ArrayList<ArrayList<Integer>>) A;
        System.out.printf("%s%5s", "Results: ", Arrays.deepToString(values.toArray()));
    }

    public static <T> void printString(T result) {
        System.out.printf("%s%5s\n", "Result: ", result);
    }

    public static void printBool(boolean result) {
        System.out.printf("%s%5s", "Result: ", result);
    }

    public static void printNewLine() {
        System.out.println("\n");
    }
}
