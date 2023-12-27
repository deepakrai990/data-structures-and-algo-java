package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @created 02/04/23 11:03 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_All_Unique_Permutations {
    ArrayList<ArrayList<Integer>> list;
    Set<ArrayList<Integer>> set;

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int n = A.size();
        list = new ArrayList<>();
        set = new HashSet<>();
        generate(0, A, n);
        return list;
    }

    public void generate(int index, ArrayList<Integer> A, int n) {
        //System.out.println("index = " + index + " arr = " + A);
        //base case
        if (index == n - 1 && set.add(A)) {
            list.add(A);
        }
        for (int i = index; i < n; i++) {
            if (i > index && A.get(i) == A.get(index)) //ignoring duplicates
                continue;
            ArrayList<Integer> temp = new ArrayList<>(A);
            swap(temp, i, index);
            generate(index + 1, temp, n);
        }
    }

    public void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
