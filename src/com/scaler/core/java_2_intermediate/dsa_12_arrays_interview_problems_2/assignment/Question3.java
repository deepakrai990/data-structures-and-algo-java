package com.scaler.core.java_2_intermediate.dsa_12_arrays_interview_problems_2.assignment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @created 17/09/22 9:28 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Majority Element
     * <p>
     * Problem Description
     * Given an array of size N, find the majority element. The majority element is the element that appears
     * more than floor(n/2) times.
     * You may assume that the array is non-empty and the majority element always exists in the array.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 5*105
     * 1 <= num[i] <= 109
     * <p>
     * <p>
     * Input Format
     * Only argument is an integer array.
     * <p>
     * <p>
     * Output Format
     * Return an integer.
     * <p>
     * <p>
     * Example Input
     * [2, 1, 2]
     * <p>
     * <p>
     * Example Output
     * 2
     * <p>
     * <p>
     * Example Explanation
     * 2 occurs 2 times which is greater than 3/2.
     **/
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int majorityElement(final int[] A) {
        int N = A.length;
        int me = A[0];
        int freq = 1;
        for (int i = 1; i < N; i++) {
            if (freq == 0) {
                me = A[i];
                freq = 1;
            } else if (me == A[i]) {
                freq++;
            } else {
                freq--;
            }
        }
        int c = 0;
        for (int i = 0; i < N; i++) {
            if (me == A[i]) {
                c++;
            }
        }
        int res = 0;
        if (c > (N / 2)) {
            res = me;
        }
        return res;
    }

    /**
     * Solution from Scaler
     **/
    private static int majorityElement1(final List<Integer> A) {
        if (A == null)
            return -1;
        int maj = A.get(0);
        int count = 1;
        int n = A.size();
        for (int i = 1; i < n; i++) {
            if (A.get(i) == maj) {
                count++;
            } else if (count == 1) {
                maj = A.get(i);
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) == maj)
                count++;
        }
        if (count > n / 2)
            return maj;
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        int result = majorityElement(A);
        System.out.println("Result : " + result);
        List<Integer> integerList = IntStream.of(A).boxed().collect(Collectors.toList());
        result = majorityElement1(integerList);
        System.out.println("Result : " + result);

    }
}
