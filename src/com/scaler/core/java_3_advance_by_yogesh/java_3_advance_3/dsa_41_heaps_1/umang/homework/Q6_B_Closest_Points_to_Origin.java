package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_41_heaps_1.umang.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @created 29/03/23 6:37 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q6_B_Closest_Points_to_Origin {
    static class Pair {
        long d;
        int[] ar;

        public Pair(long d, int[] ar) {
            this.d = d;
            this.ar = ar;
        }
    }

    class CustomComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return Long.compare(p2.d, p1.d);
        }
    }

    private int[][] solve(int[][] A, int B) {
        int[][] ans = new int[B][2];
        PriorityQueue<Pair> heap = new PriorityQueue<>(new CustomComparator());

        for (int i = 0; i < B; i++) {
            int x3 = A[i][0];
            int y3 = A[i][1];
            long d3 = 1L * (long) ((x3 * x3) + (y3 * y3));
            heap.offer(new Pair(d3, new int[]{x3, y3}));
        }

        for (int i = B; i < A.length; i++) {
            int x3 = A[i][0];
            int y3 = A[i][1];
            long d1 = 1L * (long) ((x3 * x3) + (y3 * y3));
            Pair peekel = heap.peek();

            if (peekel.d > d1) {
                heap.poll();
                heap.offer(new Pair(d1, new int[]{x3, y3}));
            }
        }

        int k = 0;
        while (!heap.isEmpty()) {
            Pair minel = heap.peek();
            ans[k][0] = minel.ar[0];
            ans[k][1] = minel.ar[1];
            k++;
            heap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 3}, {-2, 2}};
        int B = 1;
        Q6_B_Closest_Points_to_Origin solution = new Q6_B_Closest_Points_to_Origin();
        int[][] results = solution.solve(A, B);
        PrintUtils.print(results);
    }
}
