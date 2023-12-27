package com.scaler.core.java_3_advance_3.dsa_28_stacks_2;

import java.util.Stack;

/**
 * @author Deepak Kumar Rai
 * @created 27/10/23
 * @project scaler_course_code
 */
public class Q7_Sum_of_min_of_every_subarray {
    private static long sumOfMinInSubarrays(int[] A) {
        int n = A.length;
        long sum = 0;
        Stack<Integer> leftSmallerStack = new Stack<>();
        Stack<Integer> rightSmallerStack = new Stack<>();
        int[] leftSmallerIndex = new int[n];
        int[] rightSmallerIndex = new int[n];
        // Find the nearest smaller index on the left side for each element
        for (int i = 0; i < n; i++) {
            while (!leftSmallerStack.isEmpty() && A[i] <= A[leftSmallerStack.peek()]) {
                leftSmallerStack.pop();
            }
            leftSmallerIndex[i] = (leftSmallerStack.isEmpty()) ? -1 : leftSmallerStack.peek();
            leftSmallerStack.push(i);
        }
        // Find the nearest smaller index on the right side for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!rightSmallerStack.isEmpty() && A[i] <= A[rightSmallerStack.peek()]) {
                rightSmallerStack.pop();
            }
            rightSmallerIndex[i] = (rightSmallerStack.isEmpty()) ? n : rightSmallerStack.peek();
            rightSmallerStack.push(i);
        }
        // Calculate the sum of minimum elements for each subarray
        for (int i = 0; i < n; i++) {
            sum += (long) A[i] * (i - leftSmallerIndex[i]) * (rightSmallerIndex[i] - i);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5, 6};
        long result = sumOfMinInSubarrays(A);
        System.out.println("Original Array:");
        for (int value : A) {
            System.out.print(value + " ");
        }
        System.out.println("\nSum of Min in Subarrays: " + result);
    }
}
