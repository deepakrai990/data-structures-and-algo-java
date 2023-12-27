package com.scaler.core.java_3_advance_3.dsa_28_stacks_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Deepak Kumar Rai
 * @created 23/10/23
 * @project scaler_course_code
 */
public class Q2_1_st_smaller_on_right {
    /**
     * Question 2.
     * (A). Given A[N], for every element A[i], find the nearest smaller element on the right side.
     * * * Note: Nearest element < A[i] (Nearest element between indices)
     * (B). Given A[N], for every element A[i], find the nearest smaller index on the right side.
     * <></>
     * Ideas: [Bruteforce] for every element,
     * iterate on the right & get the first smaller element on the right side
     * T.C: O(N^2)
     * S.C: O(1)
     * **/
    private static int[] firstSmallerElementOnRight(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        for (int i = N - 1; i >= 0; i--) {
            // Find 1st smaller on the left
            for (int j = i + 1; j < N; j++) {
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
    private static int[] firstSmallerElementOnRight_1(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            // A[i] find first smaller on left
            while (!stk.isEmpty() && stk.peek() >= A[i]) {
                stk.pop();
            }
            if (stk.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stk.peek();
            }
            stk.push(A[i]);
        }
        return ans;
    }
    /**
     * (B). Nearest smaller index on right
     * **/
    private static int[] firstSmallerIndexOnRight(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
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
    private static int[] findNearestSmallerElement(int[] array) {
        int[] nearestSmallerElement = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= array[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nearestSmallerElement[i] = -1;
            } else {
                nearestSmallerElement[i] = stack.peek();
            }
            stack.push(array[i]);
        }
        return nearestSmallerElement;
    }
    public static void main(String[] args) {
        int[] A = {4, 6, 10, 11, 7, 8, 3, 5};
        int[] result = firstSmallerElementOnRight(A);
        PrintUtils.print(result);
        result = findNearestSmallerElement(A);
        PrintUtils.print(result);
        result = firstSmallerElementOnRight_1(A);
        PrintUtils.print(result);
        System.out.println();
        result = firstSmallerIndexOnRight(A);
        PrintUtils.print(result);
    }
}
