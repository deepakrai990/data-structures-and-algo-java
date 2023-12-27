package com.scaler.core.java_3_advance_3.dsa_28_stacks_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_1_st_smaller_on_left {
    /**
     * Question 1.
     * (a). Given A[N], for every element A[i], find nearest smaller element on left side.
     * * * Note: Nearest element < A[i] (Nearest element between indices)
     * (b). Given A[N], for every element A[i], find nearest smaller index on left side.
     * <></>
     * Ideas: [Bruteforce] for every element,
     * iterate on the left & get the first smaller element on the left side
     * T.C: O(N^2)
     * S.C: O(1)
     * **/
    private static int[] firstSmallerElementOnLeft(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        for (int i = 0; i < N; i++) {
            // Find 1st smaller on the left
            for (int j = i - 1; j >= 0; j--) {
                // is A[j] smaller ?
                if (A[j] < A[i]) {
                    ans[i] = A[j];
                    break;
                }
            }
        }
        return ans;
    }
    /**
     * Ideas: [Optimise] Use Stack,
     * T.C: O(N)
     * S.C: O(1)
     * **/
    private static int[] firstSmallerElementOnLeft_1(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            // A[i] find first smaller on left
            while (!stk.empty() && stk.peek() >= A[i]) {
                stk.pop();
            }
            if (!stk.empty()) {
                ans[i] = stk.peek();
            }
            stk.push(A[i]);
        }
        return ans;
    }
    /**
     * (b). Nearest smaller index on left
     * **/
    private static int[] firstSmallerIndexOnLeft(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            // A[i] find first smaller element on left
            while (!stk.empty() && A[stk.peek()] >= A[i]) {
                stk.pop();
            }
            if (!stk.empty()) {
                ans[i] = stk.peek();
            }
            stk.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {4, 6, 10, 11, 7, 8, 3, 5};
        int[] result = firstSmallerElementOnLeft(A);
        PrintUtils.print(result);
        result = firstSmallerElementOnLeft_1(A);
        PrintUtils.print(result);
        System.out.println();
        result = firstSmallerIndexOnLeft(A);
        PrintUtils.print(result);
    }
}
