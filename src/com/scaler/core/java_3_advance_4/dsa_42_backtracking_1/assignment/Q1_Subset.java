package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1.assignment;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @created 02/04/23 11:02 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Subset {
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
