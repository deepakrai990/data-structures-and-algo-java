package com.scaler.core.java_2_intermediate.dsa_18_sorting.assignment;

import com.scaler.core.utils.PrintUtils;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @created 29/09/22 9:46 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q3_Elements_Removal {
    private static int solve(int[] A) {
        int N = A.length;
        int[] descA = Arrays.stream(A).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        int count = 0;
        for (int i = 0; i < N; i++) {
            count = count + descA[i] * (i + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {8, 0, 10};
        int result = solve(A);
        PrintUtils.printInt(result);

    }
}
