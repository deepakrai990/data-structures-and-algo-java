package com.scaler.core.java_3_advance_1.dsa_03_arrays_3;

import com.scaler.core.java_3_advance_1.dsa_03_arrays_3.model.Interval;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 13/01/24
 * @project scaler_course_code
 */
public class Q3_Merge_it_with_existing_intervals {
    /**
     * Given N non-overlapping intervals. They are sorted based on start.
     * A new interval comes to merge it with existing intervals.
     * **/
    private static Interval[] insert(Interval[] A, Interval I) {
        int N = A.length;
        ArrayList<Interval> ans = new ArrayList<>();
        // Traverse the whole array
        for (int i = 0; i < N; i++) {
            // ith interval = A[i]
            if (A[i].end < I.start) {
                ans.add(A[i]);
            } else if (I.end < A[i].start) {
                ans.add(I);
                for (int j = i; j < N; j++) {
                    ans.add(A[j]);
                }
                return ans.toArray(new Interval[0]);
            } else {
                I.start = Math.min(I.start, A[i].start);
                I.end = Math.max(I.end, A[i].end);
            }
        }
        ans.add(I);
        return ans.toArray(new Interval[0]);
    }
    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 5),
                new Interval(8, 10),
                new Interval(11, 14),
                new Interval(15, 20),
                new Interval(19, 21),
                new Interval(21, 24),
        };
        Interval newInterval = new Interval(11, 24);

        System.out.println(Arrays.toString(intervals));

        Interval[] results = insert(intervals, newInterval);
        System.out.println(Arrays.toString(results));
    }
}
