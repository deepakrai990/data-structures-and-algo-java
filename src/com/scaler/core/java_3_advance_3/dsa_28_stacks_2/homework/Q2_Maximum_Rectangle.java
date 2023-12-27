package com.scaler.core.java_3_advance_3.dsa_28_stacks_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Stack;

/**
 * @author Deepak Kumar Rai
 * @created 02/04/23 6:35 pm
 * @project scaler_course_code
 */
public class Q2_Maximum_Rectangle {
    private static int solve(int[][] A) {
        int n = A.length, m = A[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = A[i][j] == 0 ? 0 : A[i][j] + A[i - 1][j];
            }
        }
        int ans = 0;
        for (int[] arr : A) {
            ans = Math.max(ans, largestRectangleArea(arr));
        }
        return ans;
    }

    private static int largestRectangleArea(int[] A) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        int n = A.length, j, k;
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || A[st.peek()] > A[i])) {
                j = st.pop();
                k = st.isEmpty() ? -1 : st.peek();
                ans = Math.max(ans, A[j] * (i - k - 1));
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {
                {0, 0, 1},
                {0, 1, 1},
                {1, 1, 1}
        };
        int result = solve(A);
        PrintUtils.print(result);
    }
}
