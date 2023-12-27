package com.scaler.core.java_3_advance_3.dsa_28_stacks_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Deepak Kumar Rai
 * @created 25/10/23
 * @project scaler_course_code
 */
public class Q3_1_st_greater_on_left {
    private static int[] firstGreaterElementOnLeft(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stk.empty() && stk.peek() <= A[i]) {
                stk.pop();
            }
            if (!stk.empty()) {
                ans[i] = stk.peek();
            }
            stk.push(A[i]);
        }
        return ans;
    }
    private static int[] firstGreaterIndexOnLeft(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            // A[i] find first greater element on left
            while (!stk.empty() && A[stk.peek()] <= A[i]) {
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
        int[] A = {11, 8, 6, 2, 10, 7, 4, 1}; // {4, 5, 2, 10, 3, 2};
        int[] result = firstGreaterElementOnLeft(A);
        PrintUtils.print(result);
        result = firstGreaterIndexOnLeft(A);
        PrintUtils.print(result);
    }
}
