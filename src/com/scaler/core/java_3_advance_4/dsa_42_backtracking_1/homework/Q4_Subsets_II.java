package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @created 02/04/23 11:05 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Subsets_II {
    Set<ArrayList<Integer>> set;

    private ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        set = new LinkedHashSet<>();
        set.add(new ArrayList<>());
        generate(0, A.size(), new ArrayList<>(), A);
        return new ArrayList<>(set);
    }

    private void generate(int index, int n, ArrayList<Integer> currList, ArrayList<Integer> A) {
        if (index == n) {
            return;
        }

        currList.add(A.get(index));
        set.add(new ArrayList<>(currList));
        generate(index + 1, n, currList, A);

        currList.remove(currList.size() - 1);
        generate(index + 1, n, currList, A);
    }
}
