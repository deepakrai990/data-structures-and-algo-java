package com.scaler.contest.tct_2;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @created 26/09/23 4:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Subset {
    private static int[][] subsets(int[] A) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(A);
        generateSubsets(A, 0, new ArrayList<>(), result);
        return result.stream().
                map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
    private static void generateSubsets(int[] A, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < A.length; i++) {
            if (i > index && A[i] == A[i - 1]) continue;
            current.add(A[i]);
            generateSubsets(A, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[][] results = subsets(A);
        PrintUtils.print2DArray(results);
    }
}
