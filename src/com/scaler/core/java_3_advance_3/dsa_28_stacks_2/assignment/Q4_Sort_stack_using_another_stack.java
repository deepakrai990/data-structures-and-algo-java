package com.scaler.core.java_3_advance_3.dsa_28_stacks_2.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Stack;

/**
 * @created 02/04/23 6:35 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Sort_stack_using_another_stack {
    private static int[] solve(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++)
            stack.push(A[i]);
        Stack<Integer> sortedStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > temp)
                stack.push(sortedStack.pop());  // putting back in stack
            sortedStack.push(temp);
        }
        int[] arr = new int[A.length];
        int i = A.length - 1;
        while (i >= 0)
            arr[i--] = sortedStack.pop();
        return arr;
    }

    public static void main(String[] args) {
        int[] A = {5, 4, 3, 2, 1};
        int[] results = solve(A);
        PrintUtils.print(results);
    }
}
