package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2.homework;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @created 02/04/23 11:01 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Combination_Sum_II {
    public static class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (Integer integer : A) {
            if (map.containsKey(integer)) {
                map.put(integer, map.get(integer) + 1);
            } else {
                map.put(integer, 1);
            }
        }
        ArrayList<Pair> pairs = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            pairs.add(new Pair(integer, map.get(integer)));
        }
        combinationSum(pairs, 0, B, curr, output);
        return output;
    }

    private void combinationSum(ArrayList<Pair> input, int idx, int target, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> output) {
        //Base Cases
        if (target == 0) {
            output.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0 || idx == input.size()) {
            return;
        }
        for (int i = 0; i <= input.get(idx).freq; ++i) {
            int t = target;
            for (int j = 0; j < i; ++j) {
                curr.add(input.get(idx).num);
                t -= input.get(idx).num;
            }
            combinationSum(input, idx + 1, t, curr, output);
            for (int j = 0; j < i; ++j) {
                curr.remove(curr.size() - 1);
            }
        }
    }
}
