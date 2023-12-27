package com.scaler.core.java_2_intermediate.dsa_11_arrays_interview_problems_1.assignment;

/**
 * @created 15/09/22 2:56 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {

    private static int solve(String A) {
        int n = A.length(), cnt_one = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                cnt_one++;
            }
        }

        int[] left = new int[n];
        int[] right = new int[n];

        if (A.charAt(0) == '1') {
            left[0] = 1;
        } else {
            left[0] = 0;
        }

        if (A.charAt(n - 1) == '1') {
            right[n - 1] = 1;
        } else {
            right[n - 1] = 0;
        }

        for (int i = 1; i < n; i++) {
            if (A.charAt(i) == '1') {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (A.charAt(i) == '1') {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }
        int cnt = 0, max_cnt = 0;
        int flag = 0;
        for (int i = 1; i < n - 1; i++) {
            if (A.charAt(i) == '0') {
                int sum = left[i - 1] + right[i + 1];
                if (sum < cnt_one) {
                    cnt = sum + 1;
                } else {
                    cnt = sum;
                }
                max_cnt = Math.max(max_cnt, cnt);
                cnt = 0;
                flag = 1;
            }
        }
        if (flag == 0) {
            max_cnt = cnt_one;
        }

        return max_cnt;
    }


    private static int solve1(String A) {
        return maximum_one(A);
    }

    public static int maximum_one(String s) {
        // To count all 1's in the string
        int cnt_one = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') cnt_one++;
        }
        // To store cumulative 1's
        int[] left = new int[n];
        int[] right = new int[n];
        if (s.charAt(0) == '1') left[0] = 1;
        else left[0] = 0;

        if (s.charAt(n - 1) == '1') right[n - 1] = 1;
        else right[n - 1] = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') left[i] = left[i - 1] + 1;
            else left[i] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '1') right[i] = right[i + 1] + 1;
            else right[i] = 0;
        }

        int cnt = 0, max_cnt = 0;
        for (int i = 0; i < n; ++i)
            max_cnt = Math.max(max_cnt, Math.max(right[i], left[i]));
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                int sum = left[i - 1] + right[i + 1];
                if (sum < cnt_one) cnt = sum + 1;
                else cnt = sum;
                max_cnt = Math.max(max_cnt, cnt);
                cnt = 0;
            }
        }
        return max_cnt;
    }

    public static void main(String[] args) {
        String A = "111011101";
        int result = solve(A);
        System.out.println("Result : " + result);
        result = solve1(A);
        System.out.println("Result : " + result);

    }
}
