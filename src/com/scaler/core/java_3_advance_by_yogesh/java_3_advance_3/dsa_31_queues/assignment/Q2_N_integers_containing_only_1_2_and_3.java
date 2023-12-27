package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_31_queues.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @created 09/03/23 10:29 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_N_integers_containing_only_1_2_and_3 {
     private static int[] solve(int A) {
        Queue<String> q = new LinkedList<>();
        int ans[] = new int[A];
        q.add("1");
        q.add("2");
        q.add("3");
        for (int i = 0; i < A; i++) {
            String x = q.remove();
            ans[i] = Integer.valueOf(x);
            q.add(x + "1");
            q.add(x + "2");
            q.add(x + "3");
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 7;
        int[] results = solve(A);
        PrintUtils.print(results);
    }
}
