package com.scaler.core.java_3_advance_4.dsa_52_graphs_2.assignment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 8:28 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Rotten_Oranges {
    class Pair {
        int row;
        int column;
        int time;

        Pair(int x, int y, int time) {
            this.row = x;
            this.column = y;
            this.time = time;
        }
    }
    public int solve(int[][] A) {
        int Mintime = 0;
        int N = A.length;
        int M = A[0].length;
        int freshOranges = 0;
        int row = 0, col = 0;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 2) {
                    //added rottenOranges to queue
                    q.add(new Pair(i, j, 0));
                } else if (A[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int rottenOranges = 0;
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            row = temp.row;
            col = temp.column;
            Mintime = Math.max(Mintime, temp.time);
            int[] x = {1, -1, 0, 0};
            int[] y = {0, 0, 1, -1};
            //iterate over all four directions of rotten orange to check for fresh orange
            for (int k = 0; k < x.length; k++) {
                rottenOranges += checkIfFresh(row + x[k], col + y[k], temp.time, q, N, M, A);
            }
        }
        //if all the freshOranges become rotten return mintime else -1
        return freshOranges == rottenOranges ? Mintime : -1;
    }

    public int checkIfFresh(int i, int j, int time, Queue<Pair> q, int n, int m, int[][] A) {
        int rottenOranges = 0;
        //if fresh orange found make it rotten and add to queue
        if (i >= 0 && j >= 0 && i < n && j < m && A[i][j] == 1) {
            A[i][j] = 2;
            Pair pair = new Pair(i, j, time + 1);
            q.add(pair);
            rottenOranges = 1;
        }
        return rottenOranges;
    }

}
