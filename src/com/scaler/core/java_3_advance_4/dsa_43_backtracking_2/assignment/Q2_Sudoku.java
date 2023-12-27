package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2.assignment;

import java.util.ArrayList;

/**
 * @created 02/04/23 11:00 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Sudoku {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        suduko(0, 0, a);
    }

    private boolean suduko(int r, int c, ArrayList<ArrayList<Character>> a) {
        if (c == 9) {
            c = 0;
            r++;
        }
        if (r == 9) {
            return true;
        }
        char val = a.get(r).get(c);
        if (val != '.') {
            return suduko(r, c + 1, a);
        }
        for (int i = 0; i < 9; i++) {
            int v = i + 1;
            String vv = String.valueOf(v);
            char iChar = vv.charAt(0);
            if (valid(a, r, c, iChar)) {
                a.get(r).set(c, iChar);
                if (suduko(r, c + 1, a)) {
                    return true;
                }
                a.get(r).set(c, '.');
            }
        }
        return false;
    }

    private boolean valid(ArrayList<ArrayList<Character>> a, int r, int c, char x) {
        for (int i = 0; i < 9; i++) {
            char val = a.get(r).get(i);
            if (val == x) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            char val = a.get(i).get(c);
            if (val == x) {
                return false;
            }
        }
        int iBlockStart = (r / 3) * 3;
        int jBlockStart = (c / 3) * 3;
        int iBlockEnd = iBlockStart + 3;
        int jBlockEnd = jBlockStart + 3;

        for (int i = iBlockStart; i < iBlockEnd; i++) {
            for (int j = jBlockStart; j < jBlockEnd; j++) {
                char value = a.get(i).get(j);
                if (value == x) {
                    return false;
                }
            }
        }
        return true;
    }
}
