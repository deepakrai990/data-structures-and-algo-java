package com.scaler.core.java_3_advance_3.dsa_28_stacks_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Stack;

/**
 * @created 02/04/23 6:36 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_All_Subarrays {
    private static int solve(int[] A) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            while (!st.isEmpty() && A[i] >= st.peek()) {
                res = Math.max(A[i] ^ st.pop(), res); // Max ^ 2nd max
            }
            if (!st.isEmpty()) {
                res = Math.max(A[i] ^ st.peek(), res); // Min ^ Max
            }
            st.push(A[i]);
        }
        return res;
    }

    private static int solve1(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                stack.push(A[0]);
            } else {
                while (!stack.isEmpty() && stack.peek() <= A[i]) {
                    max = Math.max(max, stack.peek() ^ A[i]);
                    stack.pop();
                }
                if (!stack.isEmpty())
                    max = Math.max(max, stack.peek() ^ A[i]);

                stack.push(A[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 4};
        int result = solve(A);
        PrintUtils.print(result);

        int result1 = solve1(A);
        PrintUtils.print(result1);
    }
}
