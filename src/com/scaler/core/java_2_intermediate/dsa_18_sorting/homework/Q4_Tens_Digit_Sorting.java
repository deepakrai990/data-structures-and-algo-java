package com.scaler.core.java_2_intermediate.dsa_18_sorting.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @created 20/02/23 1:26 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Tens_Digit_Sorting {
    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer val1, Integer val2) {
                Integer tens_digit1 = (val1 / 10) % 10;
                Integer tens_digit2 = (val2 / 10) % 10;
                if (tens_digit1 == tens_digit2) {
                    return val2 - val1;
                }
                return tens_digit1 - tens_digit2;
            }
        });
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = Stream.of(2, 24, 22, 19)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> results = solve(A);
        PrintUtils.printList(results);
    }
}
