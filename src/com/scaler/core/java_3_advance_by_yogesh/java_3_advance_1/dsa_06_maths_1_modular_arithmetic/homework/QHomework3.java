package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_06_maths_1_modular_arithmetic.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @created 10/02/23 11:21 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
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
