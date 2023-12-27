package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_03_arrays_3_interview_problems.assignment.model;

/**
 * @created 10/02/23 12:02 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "{" + start + ", " + end + "}";
    }
}
