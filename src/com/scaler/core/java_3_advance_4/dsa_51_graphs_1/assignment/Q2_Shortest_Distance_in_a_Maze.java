package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @created 02/04/23 8:31 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Shortest_Distance_in_a_Maze {
    class Tuple {
        int x;
        int y;
        int d;

        Tuple(int i, int j, int d) {
            this.x = i;
            this.y = j;
            this.d = d;
        }
    }

    private int solve(int[][] A, int[] B, int[] C) {
        int row = A.length;
        int col = A[0].length;

        int[][] distance = new int[row][col];
        for (int[] arr : distance) {
            Arrays.fill(arr, (int) 1e9);
        }
        distance[B[0]][B[1]] = 0;

        dijkstra(A, B, distance);

        return (distance[C[0]][C[1]] == (int) 1e9) ? -1 : distance[C[0]][C[1]];
    }

    private void dijkstra(int[][] A, int[] start, int[][] distance) {
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>(new Comparator<Tuple>() {
            public int compare(Tuple t1, Tuple t2) {
                return t1.d - t2.d;
            }
        });
        queue.add(new Tuple(start[0], start[1], 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.remove();
            if (tuple.d > distance[tuple.x][tuple.y]) {
                continue;
            }

            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int k = 0; k < 4; k++) {
                int x = dx[k] + tuple.x;
                int y = dy[k] + tuple.y;

                int count = 0;
                while ((x >= 0) && (x < A.length) && (y >= 0) && (y < A[0].length) && (A[x][y] == 0)) {
                    x += dx[k];
                    y += dy[k];
                    count++;
                }

                x -= dx[k];
                y -= dy[k];

                if (distance[tuple.x][tuple.y] + count < distance[x][y]) {
                    distance[x][y] = distance[tuple.x][tuple.y] + count;
                    queue.add(new Tuple(x, y, distance[x][y]));
                }
            }
        }
    }
}
