package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_4.dsa_43_greedy_algorithms.umang.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @created 30/03/23 1:37 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Activity_Selection {
    //creating custom class
    class Activity {
        int start;
        int finish;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    private int solve(int[] A, int[] B) {
        int n = A.length;
        //creating Activity[]
        Activity[] arr = new Activity[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Activity(A[i], B[i]);
        }
        //sorting based on finish time
        Arrays.sort(arr, new Comparator<Activity>() {
            public int compare(Activity a, Activity b) {
                if (a.finish < b.finish) {
                    return -1;
                } else if (a.finish > b.finish) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        //if the start time of the next is greater or equal to the end time of the previous then count++
        int i = 0; //previous counter
        int count = 1; //as base count will be 1 regardless
        for (int j = 1; j < n; j++) {
            if (arr[j].start >= arr[i].finish) {
                count++;
                i = j;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {5, 1, 3, 0, 5, 8};
        int[] B = {9, 2, 4, 6, 7, 9};

        Q2_Activity_Selection solution = new Q2_Activity_Selection();
        int result = solution.solve(A, B);
        PrintUtils.print(result);
    }
}
