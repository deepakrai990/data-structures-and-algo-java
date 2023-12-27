package com.scaler.core.java_3_advance_3.dsa_40_heaps_2.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @created 02/04/23 11:25 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_N_max_pair_combinations {
    public int[] solve(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        Set<String> set = new HashSet<>();

        //priority in reverse order
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(A[b[0]] + B[b[1]], A[a[0]] + B[a[1]]));

        maxHeap.add(new int[]{n - 1, n - 1});
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int[] temp = maxHeap.peek();
            ans[i] = A[temp[0]] + B[temp[1]];
            maxHeap.poll();
            //now this temp indexes can generate 2 possible answers
            //l-1,r & l,r-1;
            int[] first = new int[]{temp[0] - 1, temp[1]};
            int[] second = new int[]{temp[0], temp[1] - 1};

            //using set to avoid duplicacy
            if (set.add(first[0] + " " + first[1]) && first[0] >= 0)
                maxHeap.add(first);
            if (set.add(second[0] + " " + second[1]) && second[1] >= 0)
                maxHeap.add(second);
        }
        return ans;
    }
}
