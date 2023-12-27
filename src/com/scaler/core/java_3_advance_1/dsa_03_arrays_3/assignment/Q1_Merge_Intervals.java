package com.scaler.core.java_3_advance_1.dsa_03_arrays_3.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_03_arrays_3_interview_problems.assignment.model.Interval;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @created 02/04/23 8:02 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Merge_Intervals {
    private static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        int len = intervals.size();
        for (int i = 0; i < len; i++) {
            if (newInterval.end < intervals.get(i).start) {
                mergedIntervals.add(newInterval);
                newInterval = intervals.get(i);
            } else if (newInterval.start > intervals.get(i).end) {
                mergedIntervals.add(intervals.get(i));
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        mergedIntervals.add(newInterval);
        return mergedIntervals;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(6, 9);
        ArrayList<Interval> intervals = Stream.of(interval1, interval2)
                .collect(Collectors.toCollection(ArrayList::new));
        Interval newInterval = new Interval(6, 9);
        ArrayList<Interval> results = insert(intervals, newInterval);
        results.stream().forEach((interval) -> {
            System.out.println("start => " + interval.start);
            System.out.println("end => " + interval.end);
        });
    }
}
