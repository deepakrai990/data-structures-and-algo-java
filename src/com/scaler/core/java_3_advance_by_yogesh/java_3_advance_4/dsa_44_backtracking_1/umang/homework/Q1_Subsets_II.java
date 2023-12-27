package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_4.dsa_44_backtracking_1.umang.homework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @created 03/04/23 8:05 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Subsets_II {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        res.add(temp);
        Collections.sort(A);
        rec(A, res, temp, 0);
        return res;
    }

    public void rec(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int idx) {
        if (idx == A.size()) {
            return;
        }
        temp.add(A.get(idx));
        res.add(new ArrayList<>(temp));
        rec(A, res, temp, idx + 1);
        temp.remove(temp.size() - 1);
        //check duplicate elements
        while (idx + 1 < A.size() && A.get(idx) == A.get(idx + 1)) {
            idx++;
        }
        rec(A, res, temp, idx + 1);
    }
}
