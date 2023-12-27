package com.scaler.core.java_3_advance_3.dsa_28_stacks_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Deepak Kumar Rai
 * @created 26/10/23
 * @project scaler_course_code
 */
public class Q4_1_st_greater_on_right {
    public static int[] firstGreaterElementOnRight(int[] A) {
        int[] ans = new int[A.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(A[i]);
        }
        return ans;
    }
    public static int[] firstGreaterIndexOnRight(int[] A) {
        int[] ans = new int[A.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {4, 8, 5, 2, 4};
        int[] results = firstGreaterElementOnRight(A);
        PrintUtils.print(results);
        results = firstGreaterIndexOnRight(A);
        PrintUtils.print(results);
    }
}
