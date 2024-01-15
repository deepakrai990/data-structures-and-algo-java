package com.scaler.core.java_2_intermediate.dsa_18_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @created 01/10/22 1:57 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q5_Custom_Comparator_In_Java {
    public static Comparator<Integer> customComparator1() {
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (Objects.equals(a, b)) {
                    return 0;
                } else if (a > b) {
                    return 1;
                } else {
                    return  -1;
                }
            }
        };
    }
    // Using lambda expression
    public static Comparator<Integer> customComparator2() {
        return (Integer a, Integer b) -> {
            if (Objects.equals(a, b)) return 0;
            else if (a > b) return 1;
            else return  -1;
        };
    }
    public static void main(String[] args) {
        Integer[] A = {3, 2, 7, 6, 5, 4, 7, 6, 3, 2, 5};

        System.out.println("Before sorting : " + Arrays.toString(A));
        Arrays.sort(A, customComparator1());
        System.out.println("After sorting  : " + Arrays.toString(A));


        Integer[] B = {3, 2, 7, 1, 5, 22, 35, 11, 55, 45, 4, 7, 6, 3, 2, 5};
        System.out.println("Before sorting : " + Arrays.toString(B));
        Arrays.sort(B, customComparator2());
        System.out.println("After sorting  : " + Arrays.toString(B));
    }

}
