package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_30_stacks_2.homework;

import java.util.Stack;

/**
 * @created 08/03/23 8:01 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Next_Greater {
    private static int[] nextGreater(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= A[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            // Push this element
            stack.push(A[i]);
        }
        return ans;
    }

}
