package com.scaler.core.java_3_advance_4.dsa_54_graphs_4.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.*;

/**
 * @created 01/04/23 11:47 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Damaged_Roads {
    //BRUTE FORCE
    private static int solve(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] cities = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                cities[i][j] = Integer.MAX_VALUE;
            }
        }
        cities[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] currentIndex = q.poll();
            int[] nextRow = new int[]{currentIndex[0] + 1, currentIndex[1]};
            int[] nextCol = new int[]{currentIndex[0], currentIndex[1] + 1};

            if (nextRow[0] <= n) {
                cities[nextRow[0]][nextRow[1]] = Math.min(cities[nextRow[0]][nextRow[1]], A[nextRow[0] - 1]);
                q.add(nextRow);
            }
            if (nextCol[1] <= m) {
                cities[nextCol[0]][nextCol[1]] = Math.min(cities[nextCol[0]][nextCol[1]], B[nextCol[1] - 1]);
                q.add(nextCol);
            }
        }

        long minCost = 0;
        int mod = 1000000007;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                minCost = (minCost + cities[i][j]) % mod;
            }
        }
        return (int) minCost % mod;
    }

    //OPTIMIZED
    private static int solve_1(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        List<int[]> cost = new ArrayList<>(n + m);
        for (int i = 0; i < n; i++) {
            cost.add(new int[]{A[i], 1});
        }
        for (int i = 0; i < m; i++) {
            cost.add(new int[]{B[i], 0});
        }

        Collections.sort(cost, (a, b) -> Integer.compare(a[0], b[0]));
        n++;
        m++;
        long minCost = 0;
        int mod = 1000000007;

        for (int[] road : cost) {
            if (road[1] == 0) {
                minCost = (minCost + ((long) n * road[0])) % mod;
                m--;
            } else {
                minCost = (minCost + ((long) m * road[0])) % mod;
                n--;
            }
        }
        return (int) minCost % mod;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {4, 5, 6};

        int result = solve(A, B);
        PrintUtils.print(result);

        result = solve_1(A, B);
        PrintUtils.print(result);
    }
}
