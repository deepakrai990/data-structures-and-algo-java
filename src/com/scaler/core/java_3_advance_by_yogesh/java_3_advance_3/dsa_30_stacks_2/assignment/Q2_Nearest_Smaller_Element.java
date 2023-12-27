package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_30_stacks_2.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @created 07/03/23 12:53 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Nearest_Smaller_Element {
    private static int[] prevSmaller(int[] A) {
        int N = A.length;
        int Ans[] = new int[N];
        Arrays.fill(Ans, -1);
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
            while (st.size() > 0 && st.peek() >= A[i]) {
                st.pop();
            }
            if (st.size() > 0 && st.peek() < A[i]) {
                Ans[i] = st.peek();
            }
            st.push(A[i]);
        }
        return Ans;
    }
    private static int[] prevSmaller_1(int[] A) {
        int N = A.length;
        int ans[] = new int[N];
        Stack<Integer>stack = new Stack<Integer>();
        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && stack.peek()>=A[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(A[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10, 8};
        int[] results = prevSmaller(A);
        PrintUtils.print(results);

        PrintUtils.printNewLine();

        results = prevSmaller_1(A);
        PrintUtils.print(results);
    }
}
