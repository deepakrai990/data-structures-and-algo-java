package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_20_hashing_1_introduction_and_problems.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @created 16/02/23 10:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        // Sort A array
        Collections.sort(A);
        // Fill A in hashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (hm.containsKey(A.get(i))) {
                hm.put(A.get(i), hm.get(A.get(i)) + 1);
            } else {
                hm.put(A.get(i), 1);
            }
        }
        /*
            Now iterate B to check if the element is present in A,
            If present add to the answer Array.
         */
        ArrayList<Integer> ansArray = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            while (hm.containsKey(B.get(i))) { // for all the same elements if repeated
                ansArray.add(B.get(i));
                hm.put(B.get(i), hm.get(B.get(i)) - 1);
                if (hm.get(B.get(i)) == 0) {
                    hm.remove(B.get(i));
                }
            }
        }
        /*
            At this point we have all the element of B in A, now time to get the
            elements from A which are left in A.
         */
        for (int i = 0; i < A.size(); i++) {
            if (hm.containsKey(A.get(i))) {
                ansArray.add(A.get(i));
                hm.put(A.get(i), hm.get(A.get(i)) - 1);
                if (hm.get(A.get(i)) == 0) {
                    hm.remove(A.get(i));
                }
            }
        }
        return ansArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> B = Stream.of(5, 4, 2)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> results = solve(A, B);
        PrintUtils.printList(results);
    }
}
