package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_11_recursion.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;

/**
 * @created 11/02/23 7:32 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 1; i <= A; i++) temp.add(i);
        combine(0, B, temp, new ArrayList<Integer>(), ans);
        return ans;
    }

    private static void combine(int indx, int target, ArrayList<Integer> A, ArrayList<Integer> list,
                        ArrayList<ArrayList<Integer>> ans) {
        if (list.size() == target) ans.add(new ArrayList<>(list));

        for (int i = indx; i < A.size(); i++) {
            list.add(A.get(i));
            combine(i + 1, target, A, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int A = 4, B = 2;
        ArrayList<ArrayList<Integer>> results = combine(A, B);
        PrintUtils.print2DList(results);
    }

}
