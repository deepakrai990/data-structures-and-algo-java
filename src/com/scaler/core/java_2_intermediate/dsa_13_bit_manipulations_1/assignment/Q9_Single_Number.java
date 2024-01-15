package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @created 20/09/22 1:23 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q9_Single_Number {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int singleNumber(final int[] A) {
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }
    // DO NOT MODIFY THE LIST
    private static int singleNumber1(final List<Integer> A) {
        int num = 0;
        for (int val: A) {
            num ^= val;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 1};
        int result = singleNumber(A);
        PrintUtils.print(result);

        List<Integer> list = IntStream.of(A).boxed().collect(Collectors.toCollection(ArrayList::new));
        result = singleNumber1(list);
        PrintUtils.print(result);
    }
}
