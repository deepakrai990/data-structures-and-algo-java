package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @created 02/04/23 11:01 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Combination_Sum {
    ArrayList<ArrayList<Integer>> finalArray;
    ArrayList<Integer> Arr;
    HashSet<ArrayList<Integer>> hs;
    int target;

    private ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        target = B;
        finalArray = new ArrayList<ArrayList<Integer>>();
        Arr = new ArrayList<Integer>(A);
        Collections.sort(Arr);
        hs = new HashSet<ArrayList<Integer>>();
        findAll(0, B, new ArrayList<Integer>());
        return finalArray;
    }

    private void findAll(int index, int target, ArrayList<Integer> temp) {
        if (index == Arr.size()) {
            if (hs.add(new ArrayList<Integer>(temp))) {
                if (target == 0) {
                    finalArray.add(new ArrayList<Integer>(temp));
                }
            }
            return;
        }
        if (Arr.get(index) <= target) {
            temp.add(Arr.get(index));
            findAll(index, (target - Arr.get(index)), temp);
            temp.remove(temp.size() - 1);
        }
        findAll(index + 1, target, temp);
    }
}
