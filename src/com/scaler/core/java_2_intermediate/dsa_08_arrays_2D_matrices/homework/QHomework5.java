package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.homework;

import java.util.Arrays;

/**
 * @created 26/09/22 7:50 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework5 {
    /**
     * Q5. Row to Column Zero
     * <p>
     * Problem Description
     * You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0.
     * Specifically, make entire ith row and jth column zero.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A.size() <= 103
     * <p>
     * 1 <= A[i].size() <= 103
     * <p>
     * 0 <= A[i][j] <= 103
     * <p>
     * <p>
     * <p>
     * Input Format
     * First argument is a vector of vector of integers.(2D matrix).
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return a vector of vector after doing required operations.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * [1,2,3,4]
     * [5,6,7,0]
     * [9,2,0,4]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * [1,2,0,0]
     * [0,0,0,0]
     * [0,0,0,0]
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
     **/
    private static int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        for (int i = 0; i < n; i++) {
            int flag = 0;
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                for (int j = 0; j < m; j++) {
                    if (A[i][j] != 0) {
                        A[i][j] = -1;
                    }
                }
            }
        }
        for (int j = 0; j < m; j++) {
            int flag = 0;
            for (int i = 0; i < n; i++) {
                if (A[i][j] == 0) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                for (int i = 0; i < n; i++) {
                    if (A[i][j] != 0) {
                        A[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == -1) {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * If you start row wise and make one row completely zero if it has 0 then you will loose
     * information for making columns zero.
     * None element is negative so see if you may use this for not loosing infos.
     * <p>
     * Solution Approach
     * Let's start row wise first. Select rows one by one and make all the elements of that row -1 except
     * which are 0, if any element in that row is 0. Similariy you have to do the same thing for columns.
     * Now, before returning traverse the matrix and make all the -1 elements 0.
     **/
    private static int[][] solve1(int[][] A) {
        int n = A.length, m = A[0].length;
        for (int i = 0; i < n; i++) {
            int flag = 0;
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) flag = 1;
            }
            if (flag == 1) {
                for (int j = 0; j < m; j++) {
                    if (A[i][j] != 0) A[i][j] = -1;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            int flag = 0;
            for (int i = 0; i < n; i++) {
                if (A[i][j] == 0) flag = 1;
            }
            if (flag == 1) {
                for (int i = 0; i < n; i++) {
                    if (A[i][j] != 0) A[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == -1) A[i][j] = 0;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 0}, {9, 2, 0, 4}};
        int[][] results = solve(A);
        System.out.println("Results : " + Arrays.deepToString(results));
        results = solve1(A);
        System.out.println("Results : " + Arrays.deepToString(results));
    }
}
