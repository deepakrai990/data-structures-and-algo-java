package com.scaler.core.java_2_intermediate.dsa_12_arrays_interview_problems_2.homework;

import java.util.Arrays;

/**
 * @created 17/09/22 6:11 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_N_3_Repeat_Number {
    /**
     * Approach 1
     **/
    private static int repeatedNumber(int[] A) {
        int num = 0;
        int n = A.length;

        Arrays.sort(A);

        for (int i = 0; i < n; ) {
            int freq = 0;
            num = A[i];

            while (i < n && A[i] == num) {
                freq++;
                i++;
            }

            if (freq * 3 > n) {
                return num;
            }
        }
        return -1;
    }

    /**
     * Approach 2
     **/
    private static int repeatedNumberApproach2(int[] A) {
        int n = A.length;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (count1 > 0 && A[i] == element1) {
                count1 += 1;
            } else if (count2 > 0 && A[i] == element2) {
                count2 += 1;
            } else if (count1 == 0) {
                element1 = A[i];
                count1 = 1;
            } else if (count2 == 0) {
                element2 = A[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        if (count1 == 0 && count2 == 0)
            return -1;
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == element1) count1++;
            else if (A[i] == element2) count2++;
        }
        if (count1 > n / 3) return element1;
        else if (count2 > n / 3) return element2;
        else return -1;
    }

    /**
     * Solution from Scaler
     **/
    private static int repeatedNumber3(int[] A) {
        int n = A.length;
        int count1 = 0, count2 = 0;
        int first = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (first == A[i])
                count1++;
            else if (second == A[i])
                count2++;
            else if (count1 == 0) {
                count1++;
                first = A[i];
            } else if (count2 == 0) {
                count2++;
                second = A[i];
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] == first)
                count1++;
            else if (A[i] == second)
                count2++;
        }

        if (count1 > n / 3)
            return first;

        if (count2 > n / 3)
            return second;

        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 1};
        int result = repeatedNumber(A);
        System.out.println("result : " + result);
        result = repeatedNumberApproach2(A);
        System.out.println("result : " + result);
        result = repeatedNumber3(A);
        System.out.println("result : " + result);
    }
}
