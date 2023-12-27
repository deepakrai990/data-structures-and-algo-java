package com.scaler.core.java_3_advance_1.dsa_06_maths_modular_arithmetic.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @created 02/04/23 7:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Rearrange_Array {
    private static void arrange(ArrayList<Integer> A) {
        int arraySize = A.size();
        for (int i = 0; i < arraySize; i++) {
            A.set(i, (A.get(i) * arraySize));
        }

        for (int i = 0; i < arraySize; i++) {
            int oldValue = A.get(i) / arraySize;
            int newValue = A.get(oldValue) / arraySize;
            A.set(i, A.get(i) + newValue);
        }

        for (int i = 0; i < arraySize; i++) {
            A.set(i, (A.get(i) % arraySize));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = Stream.of(1, 0)
                .collect(Collectors.toCollection(ArrayList::new));
        arrange(A);
        PrintUtils.printList(A);
    }
}
