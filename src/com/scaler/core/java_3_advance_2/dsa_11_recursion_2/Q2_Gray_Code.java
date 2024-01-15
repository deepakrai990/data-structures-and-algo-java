package com.scaler.core.java_3_advance_2.dsa_11_recursion_2;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Deepak Kumar Rai
 * @created 15/01/24
 * @project scaler_course_code
 */
public class Q2_Gray_Code {
    /**
     * Problem: Given N, generate all N bits number's gray code sequence.
     * Return any valid sequence.
     * Note: Numbers in sequence should differ by one bit.
     * **/
    private static int[] grayCode(int N) {
        if (N == 1) {
            return new int[] {0, 1};
        }
        int[] p = grayCode(N - 1); // Grady code of (N - 1)
        int x = p.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            ans.add(p[i]);
        }
        for (int i =  x - 1; i >= 0; i--) {
            ans.add(p[i] + (1 << (N - 1) /*2 ^ (N - 1)*/));
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    private static List<Integer> grayCode1(int N) {
        if (N == 1) {
            return Stream.of(0, 1).collect(Collectors.toList());
        }
        List<Integer> p = grayCode1(N - 1); // Grady code of (N - 1)
        int x = p.size();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            ans.add(p.get(i));
        }
        for (int i =  x - 1; i >= 0; i--) {
            ans.add(p.get(i) + (1 << (N - 1) /*2 ^ (N - 1)*/));
        }
        return ans;
    }
    public static void main(String[] args) {
        int N = 3;

        int[] results = grayCode(N);
        PrintUtils.print(results);
        System.out.println("Gray Code Sequence for " + N + " bits: " + Arrays.toString(results));

        System.out.println("--------------------------------------------------------------");

        List<Integer> results1 = grayCode1(N);
        PrintUtils.print(results1);

        System.out.println("Gray Code Sequence for " + N + " bits: " + results1);
    }
}
