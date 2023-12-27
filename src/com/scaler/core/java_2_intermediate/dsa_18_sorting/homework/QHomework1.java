package com.scaler.core.java_2_intermediate.dsa_18_sorting.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @created 20/02/23 1:25 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static String largestNumber(final int[] A) {
        int N = A.length;
        StringBuilder sb = new StringBuilder();
        String[] str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = Integer.toString(A[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String A, String B) {
                String C = A.concat(B);
                String D = B.concat(A);
                return D.compareTo(C);
            }
        });
        if (str[0].equals("0") && str[N - 1].equals("0")) {
            return "0";
        }
        for (int i = 0; i < N; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
    private static String largestNumber1(final int[] A) {
        int N = A.length;
        StringBuilder sb = new StringBuilder();
        String[] str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = Integer.toString(A[i]);
        }
        Arrays.sort(str, (A1, B) -> {
            String C = A1.concat(B);
            String D = B.concat(A1);
            return D.compareTo(C);
        });
        if (str[0].equals("0") && str[N - 1].equals("0")) {
            return "0";
        }
        for (int i = 0; i < N; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[]  A = {3, 30, 34, 5, 9};
        String result = largestNumber(A);
        PrintUtils.printString(result);
        result = largestNumber1(A);
        PrintUtils.printNewLine();
        PrintUtils.printString(result);
    }
}
