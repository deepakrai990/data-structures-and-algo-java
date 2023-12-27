package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_31_queues.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 09/03/23 10:29 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Perfect_Numbers {
    private static String solve(int A) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");

        for (int i = 0; i < A - 1; i++) {
            String str = q.remove();
            q.add(str + "1");
            q.add(str + "2");
        }

        return q.peek() + new StringBuilder(q.peek()).reverse().toString();
    }

    public static void main(String[] args) {
        int A = 3;
        String result = solve(A);
        PrintUtils.print(result);
    }
}
