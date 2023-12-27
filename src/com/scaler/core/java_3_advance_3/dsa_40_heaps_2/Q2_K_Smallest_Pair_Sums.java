package com.scaler.core.java_3_advance_3.dsa_40_heaps_2;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Deepak Kumar Rai
 * @created 27/11/23
 * @project scaler_course_code
 */
public class Q2_K_Smallest_Pair_Sums {
    /**
     * Question: K the smallest pair sums
     * Given two sorted arrays. Print K the smallest pair sums.
     * Note: Consider a single pair only once
     * A[i] + B[j] is a pair
     **/
    private static void smallestKPairs(int[] A, int[] B, int K) {
        int N = A.length, M = B.length;
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> meanHeap =
                new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        Set<String> hashSet = new HashSet<>(); // To Store pairs
        meanHeap.add(new Pair<>(A[0] + B[0], new Pair<>(0, 0)));
        hashSet.add(0 + "_" + 0); // Insert into HashSet
        for (int i = 1; i <= K; i++) {
            Pair<Integer, Pair<Integer, Integer>> data = meanHeap.peek();
            meanHeap.poll();
            assert data != null;
            int val = data.getKey();
            int row = data.getValue().getKey();
            int column = data.getValue().getValue();
            System.out.println(A[data.getValue().getKey()] + " + " + B[data.getValue().getValue()] + " = " + val);
            // for row, column possibilities row + 1, row, column + 1
            if (column + 1 < M && !hashSet.contains(row + "_" + (column + 1))) {
                val = A[row] + B[column + 1];
                meanHeap.add(new Pair<>(val, new Pair<>(row, column + 1)));
                hashSet.add(row + "_" + (column + 1));
            }
            if (row + 1 < N && !hashSet.contains((row + 1) + "_" + column)) {
                val = A[row + 1] + B[column];
                meanHeap.add(new Pair<>(val, new Pair<>(row + 1, column)));
                hashSet.add((row + 1) + "_" + column);
            }
        }
    }
    /**
     * T.C: K * {log K + log K + log K} = O(K log K)
     * S.C: O(K)
     * **/
    public static void main(String[] args) {
        int[] A = {2, 5, 8, 11, 13};
        int[] B = {3, 7, 9, 12, 15, 16, 20};
        int K = 5;
        smallestKPairs(A, B, K);
    }
}
