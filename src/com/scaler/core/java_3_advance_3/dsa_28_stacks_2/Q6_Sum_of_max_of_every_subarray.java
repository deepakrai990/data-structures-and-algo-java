package com.scaler.core.java_3_advance_3.dsa_28_stacks_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Deepak Kumar Rai
 * @created 27/10/23
 * @project scaler_course_code
 */
public class Q6_Sum_of_max_of_every_subarray {
    /**
     * Question:
     * Given A[N] distinct elements. Find the sum of the max of the every subarray.
     * **/
    private static int maxSumEverySubarray(int[] A) {
        int N = A.length;
        int[] left = firstGreaterIndexLeft(A);
        int[] right = firstGreaterIndexRight(A);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int p1 = left[i];
            int p2 = right[i];
            int s = i - p1;
            int e = p2 - i;
            int contributions = s * e;
            ans += A[i] * contributions;
        }
        return ans;
    }
    private static int[] firstGreaterIndexLeft(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, - 1); // Initialize with -1 if no greater index
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stk.isEmpty() && A[stk.peek()] <= A[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(i);
        }
        return ans;
    }
    private static int[] firstGreaterIndexRight(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, N); // Initialize with N if no greater index
        Stack<Integer> stk = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!stk.isEmpty() && A[stk.peek()] <= A[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(i);
        }
        return ans;
    }
    public static long sumOfMaxInSubarrays_1(int[] A) {
        int n = A.length;
        long sum = 0;
        Stack<Integer> leftGreaterStack = new Stack<>();
        Stack<Integer> rightGreaterStack = new Stack<>();
        int[] leftGreaterIndex = new int[n];
        int[] rightGreaterIndex = new int[n];
        // Find the nearest greater index on the left side for each element
        for (int i = 0; i < n; i++) {
            while (!leftGreaterStack.isEmpty() && A[i] >= A[leftGreaterStack.peek()]) {
                leftGreaterStack.pop();
            }
            leftGreaterIndex[i] = (leftGreaterStack.isEmpty()) ? -1 : leftGreaterStack.peek();
            leftGreaterStack.push(i);
        }
        // Find the nearest greater index on the right side for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!rightGreaterStack.isEmpty() && A[i] >= A[rightGreaterStack.peek()]) {
                rightGreaterStack.pop();
            }
            rightGreaterIndex[i] = (rightGreaterStack.isEmpty()) ? n : rightGreaterStack.peek();
            rightGreaterStack.push(i);
        }
        // Calculate the sum of maximum elements for each subarray
        for (int i = 0; i < n; i++) {
            sum += (long) A[i] * (i - leftGreaterIndex[i]) * (rightGreaterIndex[i] - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 10, 1, 4, 2, 8, 6, 4, 14, 2, 19}; // {4, 2, 3};
        long result = maxSumEverySubarray(A);
        PrintUtils.print(result);
        result = sumOfMaxInSubarrays_1(A);
        PrintUtils.print(result);
    }
}
