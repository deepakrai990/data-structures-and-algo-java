package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_4.dsa_44_backtracking_1.umang.assignment;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @created 01/04/23 11:07 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Subset {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        result.add(new ArrayList<>());
        generateSubset(0, new ArrayList<>(), A, A.size());
        return result;
    }

    public void generateSubset(int index, ArrayList<Integer> list, ArrayList<Integer> array, int n) {
        if (index == n) {
            return;
        }
        list.add(array.get(index));
        result.add(new ArrayList<>(list));
        generateSubset(index + 1, list, array, n);

        list.remove(list.size() - 1);
        generateSubset(index + 1, list, array, n);
    }
}
