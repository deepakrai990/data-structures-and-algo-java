package com.scaler.core.java_2_intermediate.dsa_04_introduction_to_arrays.homework;

/**
 * @created 19/09/22 8:37 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework6 {
    /**
     * Q6. Problems on 1D Arrays-2 MCQ D
     * <p>
     * What will be the output of the following code?
     * <p>
     * class Main {
     * <p>
     * static void fun(int[]arr) {
     * arr[3] = 98;
     * return;
     * }
     * <p>
     * public static void main(String args[]) {
     * int[]arr = {10,20,30,40,50};
     * fun(arr);
     * System.out.println(arr[3]);
     * }
     * }
     * <p>
     * Answer : 98
     **/

    private static void fun(int[] arr) {
        arr[3] = 98;
        return;
    }

    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40, 50};
        fun(arr);
        System.out.println(arr[3]);
    }
}
