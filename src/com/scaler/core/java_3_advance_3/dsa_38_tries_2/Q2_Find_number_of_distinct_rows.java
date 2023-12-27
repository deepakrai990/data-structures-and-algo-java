package com.scaler.core.java_3_advance_3.dsa_38_tries_2;

/**
 * @author Deepak Kumar Rai
 * @created 23/11/23
 * @project scaler_course_code
 */
class Node {
    public Node[] c = new Node[2];
    public Node() {
        c[0] = null;
        c[1] = null;
    }
}
public class Q2_Find_number_of_distinct_rows {
    /**
     * Given a binary two D (2D) matrix, find number of distinct rows.
     * Note: For every row, consider only one occurrence.
     * Constraints: M > 64
     * **/
    private static boolean insert(int[] A, Node root) {
        Node temp = root;
        int m = A.length;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            // insert A[i] int temp
            if (temp.c[A[i]] != null) {
                temp = temp.c[A[i]];
            } else {
                Node newNode = new Node();
                temp.c[A[i]] = newNode;
                temp = temp.c[A[i]];
                flag = true;
            }
        }
        return flag;
    }
    private static int uniqueRows(int[][] mat, int N) {
        int count = 0;
        Node root = new Node();
        for (int i = 0; i < N; i++) {
            // insert ith row => mat[i]
            if (insert(mat[i], root)) {
                count = count + 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0}
        };
        int distinctRows = uniqueRows(matrix, matrix.length);
        System.out.println("Number of distinct rows: " + distinctRows);
    }
}
