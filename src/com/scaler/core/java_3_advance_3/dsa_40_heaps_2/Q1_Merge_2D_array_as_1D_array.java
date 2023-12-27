package com.scaler.core.java_3_advance_3.dsa_40_heaps_2;

import com.scaler.core.utils.PrintUtils;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Merge_2D_array_as_1D_array {
    /**
     * Question: Given 2D matrix[N][M]. Every row is sorted, merge entire data into 1D sorted list
     * and return sorted array.
     * **/
    private static int[] merge(int[][] mat) {
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        int N = mat.length;
        int M = mat[0].length;
        // Insert th 0th column
        for (int i = 0; i < N; i++) {
            minHeap.add(new Pair<>(mat[i][0], new Pair<>(i, 0)));
        }
        List<Integer> ans = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> data = minHeap.peek();
            int val = data.getKey();
            int row = data.getValue().getKey();
            int column = data.getValue().getValue();
            minHeap.poll();
            ans.add(val);
            if (column + 1 < M) {
                minHeap.add(new Pair<>(
                        mat[row][column + 1],
                        new Pair<>(row, column + 1)
                        )
                );
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 7, 10, 17, 25, 34},
                {-6, 0, 1, 8, 11, 16},
                {3, 4, 6, 14, 21, 26},
                {7, 10, 14, 19, 23, 27}
        };
        int[] results = merge(matrix);
        PrintUtils.print(results);
    }
}
