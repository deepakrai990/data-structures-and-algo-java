package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_30_stacks_2.assignment;

import java.util.Arrays;
import java.util.Stack;

/**
 * @created 07/03/23 12:59 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Largest_Rectangle_In_Histogram {
    private static int largestRectangleArea(int[] A) {
        int n = A.length;
        int ans = 0;
        int left[] = smallestElementIndexLeft(A);
        int right[] = smallestElementIndexRight(A);

        for (int i = 0; i < n; i++) {
            int p1 = left[i];
            int p2 = right[i];
            int width = p2 - p1 - 1;
            ans = Math.max(ans, width * A[i]);
        }
        return ans;
    }

    private static int[] smallestElementIndexLeft(int[] A) {
        int n = A.length;
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private static int[] smallestElementIndexRight(int[] A) {
        int n = A.length;
        int ans[] = new int[n];
        Arrays.fill(ans, n);
        Stack<Integer> st = new Stack();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}
