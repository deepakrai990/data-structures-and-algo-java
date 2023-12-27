package com.scaler.core.java_3_advance_3.dsa_29_queues.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 02/04/23 6:28 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Perfect_Numbers {
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
