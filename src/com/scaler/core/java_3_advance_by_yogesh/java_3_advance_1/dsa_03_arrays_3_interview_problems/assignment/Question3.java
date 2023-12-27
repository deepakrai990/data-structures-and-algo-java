package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_03_arrays_3_interview_problems.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_03_arrays_3_interview_problems.assignment.model.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @created 09/02/23 11:55 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Question3 {
    private static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<>();

        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        int n = intervals.size();
        Interval oldIntr = intervals.get(0);
        for (int i = 1; i < n; i++) {

            Interval currIntr = intervals.get(i);
            if (oldIntr.end < currIntr.start) {

                ans.add(oldIntr);
                oldIntr = currIntr;
            } else if (oldIntr.end > currIntr.start) {

                oldIntr.start = Math.min(oldIntr.start, currIntr.start);
                oldIntr.end = Math.max(oldIntr.end, currIntr.end);
            }

        }
        ans.add(oldIntr);
        return ans;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);
        ArrayList<Interval> intervals = Stream.of(interval1, interval2, interval3, interval4)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Interval> results = merge(intervals);
        results.stream().forEach((interval) -> {
            System.out.println(interval.toString());
        });
    }
}
