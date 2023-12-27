package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_31_queues.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @created 09/03/23 10:30 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Reversing_Elements_Of_Queue {
    private static int[] solve(int[] A, int B) {
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < A.length; i++) qu1.add(A[i]);
        for (int i = 0; i < B; i++) {
            int no = qu1.peek();
            qu1.remove();
            st.add(no);
        }
        while (st.size() != 0) {
            qu2.add(st.pop());
        }
        while (!qu1.isEmpty()) {
            int no = qu1.peek();
            qu1.remove();
            qu2.add(no);
        }
        int[] res = new int[qu2.size()];
        int k = 0;
        while (!qu2.isEmpty()) {
            int no = qu2.peek();
            qu2.remove();
            res[k] = no;
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        int B = 2;
        int[] results = solve(A, B);
        PrintUtils.print(results);
    }
}
