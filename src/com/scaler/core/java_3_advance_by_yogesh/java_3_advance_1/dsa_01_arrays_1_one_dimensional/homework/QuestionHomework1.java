package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_01_arrays_1_one_dimensional.homework;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @created 20/01/23 9:35 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QuestionHomework1 {
    private static int[] plusOne(int[] A) {
        int carry = 1;
        int num;
        int size = A.length;

        // traversing the digits of the number in reverse order
        for (int i = size - 1; i >= 0; i--) {

            num = A[i];
            num += carry;
            carry = 0;

            if (num == 10) {
                num = 0;
                carry = 1;
            }

            A[i] = num;

        }

        ArrayList<Integer> res = new ArrayList<>();
        if (carry == 1)
            res.add(1);

        for (int x : A) {
            if (x == 0 && res.size() == 0)
                continue;
            res.add(x);
        }
        int[] results = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            results[i] = res.get(i);
        return results;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] results = plusOne(A);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
