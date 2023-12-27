package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.assignment;

import java.util.ArrayList;

/**
 * @created 10/09/22 12:07 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    /**
     * Q5. Anti Diagonals
     * <p>
     * Problem Description
     * Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
     * <p>
     * <p>
     * Problem Constraints
     * 1<= N <= 1000
     * 1<= A[i][j] <= 1e9
     * <p>
     * <p>
     * Input Format
     * First argument is an integer N, denoting the size of square 2D matrix.
     * Second argument is a 2D array A of size N * N.
     * <p>
     * <p>
     * Output Format
     * Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
     * The vacant spaces in the grid should be assigned to 0.
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * 3
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * Input 2:
     * <p>
     * 1 2
     * 3 4
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * 1 0 0
     * 2 4 0
     * 3 5 7
     * 6 8 0
     * 9 0 0
     * Output 2:
     * <p>
     * 1 0
     * 2 3
     * 4 0
     * <p>
     * <p>
     * Example Explanation
     * For input 1:
     * The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making
     * the row as [1, 0, 0].
     * The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making
     * the row as [2, 4, 0].
     * The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making
     * the row as [3, 5, 7].
     * The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making
     * the row as [6, 8, 0].
     * The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the
     * row as [9, 0, 0].
     * For input 2:
     * <p>
     * The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making
     * the row as [1, 0, 0].
     * The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making
     * the row as [2, 4, 0].
     * The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making
     * the row as [3, 0, 0].
     **/
    private static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int l = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2 * l - 1; ++i) {
            int offset = i < l ? 0 : i - l + 1;
            ArrayList<Integer> row = new ArrayList<Integer>();
            int k = 0;
            for (int j = offset; j <= i - offset; ++j) {
                row.add(A.get(j).get(i - j));
                k++;
            }
            for (int j = k; j < l; j++) {
                row.add(0);
            }
            res.add(row);
        }
        return res;
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * Let’s look at how the coordinates change when you move from one element to the other in the anti-diagonal.
     * With every movement, the row increases by one, and the column decreases by one ( or in other words,
     * (1, -1) gets added to the current coordinates).
     * Now, all we need to know is the start ( or the first element ) in each diagonal.
     * Can you figure out which elements qualify as the first elements in each diagonal?
     * <p>
     * Solution Approach
     * Let’s look at how the coordinates change when you move from one element to the other in the anti-diagonal.
     * With every movement, the row increases by one, and the column decreases by one ( or in other words, (1, -1)
     * gets added to the current coordinates).
     * Now, all we need to know is the start ( or the first element ) in each diagonal.
     * Can you figure out which elements qualify as the first elements in each diagonal?
     **/
    private static ArrayList<ArrayList<Integer>> diagonal1(ArrayList<ArrayList<Integer>> A) {
        int l = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2 * l - 1; ++i) {
            int offset = i < l ? 0 : i - l + 1;
            ArrayList<Integer> row = new ArrayList<Integer>();
            int k = 0;
            for (int j = offset; j <= i - offset; ++j) {
                row.add(A.get(j).get(i - j));
                k++;
            }
            for (int j = k; j < l; j++) {
                row.add(0);
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
