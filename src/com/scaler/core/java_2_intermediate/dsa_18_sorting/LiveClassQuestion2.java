package com.scaler.core.java_2_intermediate.dsa_18_sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @created 01/10/22 1:57 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    public static void main(String[] args) {
        Integer[] A = {3, 2, 7, 6, 5, 4, 7, 6, 3, 2, 5};
        Arrays.sort(A, customComparator1());
        System.out.println(Arrays.toString(A));
        Integer[] B = {3, 2, 7, 1, 5, 22, 35, 11, 55, 45, 4, 7, 6, 3, 2, 5};
        Arrays.sort(B, customComparator2());
        System.out.println(Arrays.toString(B));
    }

    public static Comparator<Integer> customComparator1() {
        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a == b) {
                    return 0;
                } else if (b > a) {
                    return 1;
                } else {
                    return  -1;
                }
            }
        };
        return customComparator;
    }
    // Using lambda expression
    public static Comparator<Integer> customComparator2() {
        Comparator<Integer> customComparator = (Integer a, Integer b) -> {
            if (a == b) return 0;
            else if (b > a) return 1;
            else return  -1;
        };
        return customComparator;
    }

}
