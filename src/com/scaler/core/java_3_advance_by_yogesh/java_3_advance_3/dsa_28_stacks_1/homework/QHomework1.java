package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_28_stacks_1.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Stack;

/**
 * @created 04/03/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    //Given -- size of Array C[] is A
    private static int solve(int A, int B, int[] C) {
        if (A == 1) return C[0]; //if only one pass return first element
        Stack<Integer> st = new Stack<>();
        st.push(B); //add initial player id to stack

        for (int i = 0; i < A; i++) {
            if (C[i] != 0) //it means forward pass to next player - so add it to stack
                st.push(C[i]);

            else //it means passing the ball to previous player - so remove the current player from stack
                st.pop();
        }
        return st.peek(); //peek contains current player possess the ball
    }

    public static void main(String[] args) {
        int A = 10;
        int B = 23;
        int[] C = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};
        int result = solve(A, B, C);
        PrintUtils.printInt(result);
    }
}
