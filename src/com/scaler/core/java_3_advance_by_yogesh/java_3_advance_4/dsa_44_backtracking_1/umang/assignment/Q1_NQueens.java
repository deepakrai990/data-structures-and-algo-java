package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_4.dsa_44_backtracking_1.umang.assignment;

import java.util.*;

/**
 * @created 01/04/23 11:00 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_NQueens {
    List<int[]> list; // store all possible answers
    int[] row; // store answer in row col format in recursive call
    Set<Integer> cols; // columns hashset
    Set<Integer> LRD; //left to right diagonal
    Set<Integer> RLD; //right to left diagonal

    private String[][] solveNQueens(int A) {
        row = new int[A];
        list = new ArrayList<>();
        cols = new HashSet<>();
        LRD = new HashSet<>();
        RLD = new HashSet<>();

        generate(0, A);
        return generateMatrix(list, A);
    }

    private void generate(int index, int n) {
        if (index == n) {
            list.add(Arrays.copyOf(row, n)); // storing valid answers in list
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(index, col)) {
                row[index] = col;

                cols.add(col);
                LRD.add(index - col);
                RLD.add(index + col);
                generate(index + 1, n);

                //backtracking
                cols.remove(col);
                LRD.remove(index - col);
                RLD.remove(index + col);
            }
        }
    }

    private boolean isValid(int r, int c) {
        if ((cols != null && cols.contains(c)) || (LRD != null && LRD.contains(r - c)) || (RLD != null && RLD.contains(r + c)))
            return false;
        return true;
    }

    private String[][] generateMatrix(List<int[]> list, int n) {
        int len = list.size();
        String[][] allSolutions = new String[len][n];
        //loop for all solution array
        for (int k = 0; k < len; k++) {

            int solution[] = list.get(k);
            //each solution will get stored in matrix
            String[] matrix = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (solution[i] == j)
                        row.append('Q');
                    else
                        row.append('.');
                }
                matrix[i] = row.toString();
            }
            allSolutions[k] = matrix;
        }
        return allSolutions;
    }
}
