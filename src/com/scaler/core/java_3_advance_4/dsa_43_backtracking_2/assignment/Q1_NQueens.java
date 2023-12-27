package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @created 02/04/23 10:59 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_NQueens {
    HashSet<Integer> HsCol = new HashSet<>();
    HashSet<Integer> HsRU = new HashSet<>();
    HashSet<Integer> HsLU = new HashSet<>();
    ArrayList<ArrayList<String>> ans = new ArrayList<>();

    private ArrayList<ArrayList<String>> solveNQueens(int A) {
        char[][] ch = new char[A][A];
        for (int i = 0; i < A; i++) {
            Arrays.fill(ch[i], '.');
        }
        generate(ch, 0, A);
        return ans;
    }

    private void generate(char[][] ch, int idx, int N) {
        if (idx == N) {
            ans.add(printArr(ch));
            return;
        }
        for (int j = 0; j < N; j++) {
            if (HsCol.contains(j)) continue;
            if (HsRU.contains(idx + j)) continue;
            if (HsLU.contains(idx - j)) continue;
            HsCol.add(j);
            HsRU.add(idx + j);
            HsLU.add(idx - j);
            ch[idx][j] = 'Q';
            generate(ch, idx + 1, N);
            ch[idx][j] = '.';
            HsLU.remove(idx - j);
            HsRU.remove(idx + j);
            HsCol.remove(j);
        }
    }

    private ArrayList<String> printArr(char[][] ch) {
        ArrayList<String> ref = new ArrayList<>();
        int N = ch.length;
        for (int i = 0; i < N; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < N; j++) {
                s.append(ch[i][j]);
            }
            ref.add(s.toString());
        }
        return ref;
    }
}
