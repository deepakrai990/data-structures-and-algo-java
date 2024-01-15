package com.scaler.core.java_2_intermediate.dsa_18_sorting;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @created 30/09/22 9:10 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Find_min_cost_to_remove_all_elements {
    /**
     * Problem: Element Removal
     * Given A[N] elements, at every step remove an A[] element.
     * Cost to remove an element is equal to the sum of all elements in array present at that instance.
     * Find minimum cost to remove all elements
     * **/
    private static int minimumCost(int[] A) {
        A = IntStream.of(A)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
        int N = A.length;
        int cost = 0;
        for (int i = 0; i < N; i++) {
            // How many times will A[i] occur = (i + 1) times
            cost = cost + A[i] * (i + 1);
        }
        return cost;
    }
    public static void main(String[] args) {
        int[] A = {3, 6, 2, 4};

        int result = minimumCost(A);
        PrintUtils.print(result);
    }
}
