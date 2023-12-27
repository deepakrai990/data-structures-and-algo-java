package com.scaler.core.java_2_intermediate.dsa_29_subsequences_subsets.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;;

/**
 * @created 05/03/23 6:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Subset {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        result.add(new ArrayList<>());
        generateSubset(0, new ArrayList<>(), A, A.size());
        return result;
    }

    private void generateSubset(int index, ArrayList<Integer> list, ArrayList<Integer> array, int n) {
        if (index == n) {
            return;
        }
        list.add(array.get(index));
        result.add(new ArrayList<>(list));
        generateSubset(index + 1, list, array, n);

        list.remove(list.size() - 1);
        generateSubset(index + 1, list, array, n);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = IntStream.of(1, 2, 3).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Q3_Subset q3_subset = new Q3_Subset();
        ArrayList<ArrayList<Integer>> results = q3_subset.subsets(A);
        PrintUtils.print2DList(results);
    }
}
