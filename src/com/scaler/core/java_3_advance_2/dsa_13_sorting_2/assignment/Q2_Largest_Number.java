package com.scaler.core.java_3_advance_2.dsa_13_sorting_2.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @created 02/04/23 7:29 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Largest_Number {
    private static String largestNumber(final List<Integer> A) {
        List<String> B = new ArrayList<>();
        for (int i = 0; i < A.size(); ++i) {
            B.add(A.get(i).toString());
        }
        largestNumberMergeSort(B, 0, A.size() - 1);
        StringBuilder ans = new StringBuilder();
        for (String it : B) {
            ans.append(it);
        }
        if (ans.charAt(0) == '0') return "0";
        return ans.toString();
    }

    private static void largestNumberMergeSort(List<String> A, int start, int end) {
        //Base Case
        if (start == end) return;
        int mid = (start + end) >> 1;
        largestNumberMergeSort(A, start, mid);
        largestNumberMergeSort(A, mid + 1, end);
        merge(A, start, mid, end);
    }

    private static void merge(List<String> A, int start, int mid, int end) {
        List<String> helper = new ArrayList<>();
        int p1 = start, p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            if ((A.get(p1) + A.get(p2)).compareTo(A.get(p2) + A.get(p1)) >= 0) {
                helper.add(A.get(p1++));
            } else {
                helper.add(A.get(p2++));
            }
        }
        while (p1 <= mid) helper.add(A.get(p1++));
        while (p2 <= end) helper.add(A.get(p2++));
        for (int i = 0; i < helper.size(); ++i) {
            A.set(i + start, helper.get(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> A = Stream.of(3, 30, 34, 5, 9)
                .collect(Collectors.toCollection(ArrayList::new));
        String result = largestNumber(A);
        PrintUtils.printString(result);
    }
}
