package com.scaler.core.java_3_advance_2.dsa_19_hashing_1.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;

/**
 * @created 02/04/23 7:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Colorful_Number {
    private static int colorful(int A) {

        int length = String.valueOf(A).length();
        int[] arr = new int[length];

        int i = length - 1;

        while (A > 0) {
            arr[i] = A % 10;
            A = A / 10;
            i--;
        }

        HashSet<Integer> hs = new HashSet<>();

        for (int m = 0; m < arr.length; m++) {
            int product = 1;
            for (int n = m; n < arr.length; n++) {
                product = product * arr[n];

                if (hs.contains(product)) {
                    return 0;
                } else {
                    hs.add(product);
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int A = 23;
        int result = colorful(A);
        PrintUtils.print(result);
    }
}
