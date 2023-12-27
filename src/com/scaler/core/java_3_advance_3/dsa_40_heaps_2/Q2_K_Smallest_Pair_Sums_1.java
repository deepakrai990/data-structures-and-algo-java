package com.scaler.core.java_3_advance_3.dsa_40_heaps_2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 28/11/23
 * @project scaler_course_code
 */
public class Q2_K_Smallest_Pair_Sums_1 {
    static class Pair {
        int index1, index2;
        public Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return index1 == pair.index1 && index2 == pair.index2;
        }
        @Override
        public int hashCode() {
            return Objects.hash(index1, index2);
        }
    }

    static class PairSum {
        Pair pair;
        int sum;

        public PairSum(Pair pair, int sum) {
            this.pair = pair;
            this.sum = sum;
        }
    }
    private static void printKSmallestSums(int[] arr1, int[] arr2, int k) {
        if (arr1 == null || arr2 == null || k <= 0) {
            System.out.println("Invalid input");
            return;
        }
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len1 * len2 < k) {
            System.out.println("K is too large");
            return;
        }
        PriorityQueue<PairSum> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        HashSet<Pair> visitedPairs = new HashSet<>();
        // Add the initial pair (0, 0) to the min-heap and mark it as visited
        Pair initialPair = new Pair(0, 0);
        minHeap.offer(new PairSum(initialPair, arr1[initialPair.index1] + arr2[initialPair.index2]));
        visitedPairs.add(initialPair);
        // Print the K smallest pair sums
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            PairSum current = minHeap.poll();
            System.out.println(arr1[current.pair.index1] + " + " + arr2[current.pair.index2] + " = " + current.sum);
            // Add the next pair from the same array to the min-heap if not visited
            Pair nextPair1 = new Pair(current.pair.index1 + 1, current.pair.index2);
            Pair nextPair2 = new Pair(current.pair.index1, current.pair.index2 + 1);
            if (nextPair1.index1 < len1 && visitedPairs.add(nextPair1)) {
                minHeap.offer(new PairSum(nextPair1, arr1[nextPair1.index1] + arr2[nextPair1.index2]));
            }
            if (nextPair2.index2 < len2 && visitedPairs.add(nextPair2)) {
                minHeap.offer(new PairSum(nextPair2, arr1[nextPair2.index1] + arr2[nextPair2.index2]));
            }
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 8, 11, 13};
        int[] arr2 = {3, 7, 9, 12, 15, 16, 20};
        int k = 5;
        printKSmallestSums(arr1, arr2, k);
    }
}
