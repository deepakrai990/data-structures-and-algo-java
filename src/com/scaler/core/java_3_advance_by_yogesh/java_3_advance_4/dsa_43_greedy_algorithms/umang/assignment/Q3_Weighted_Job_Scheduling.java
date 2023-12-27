package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_4.dsa_43_greedy_algorithms.umang.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @created 30/03/23 1:37 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Weighted_Job_Scheduling {
    class Job {
        int start, finish, profit;

        Job(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }

    class JobComparator implements Comparator<Job> {
        public int compare(Job a, Job b) {
            return a.finish < b.finish ? -1 : a.finish == b.finish ? 0 : 1;
        }
    }

    static public int binarySearch(Job jobs[], int index) {
        // Initialize 'lo' and 'hi' for Binary Search
        int lo = 0, hi = index - 1;

        // Perform binary Search iteratively
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (jobs[mid].finish <= jobs[index].start) {
                if (jobs[mid + 1].finish <= jobs[index].start)
                    lo = mid + 1;
                else
                    return mid;
            } else
                hi = mid - 1;
        }

        return -1;
    }

    public int schedule(Job jobs[]) {
        // Sort jobs according to finish time
        Arrays.sort(jobs, new JobComparator());

        // Create an array to store solutions of subproblems.
        // table[i] stores the profit for jobs till jobs[i]
        // (including jobs[i])
        int n = jobs.length;
        int table[] = new int[n];
        table[0] = jobs[0].profit;

        // Fill entries in M[] using recursive property
        for (int i = 1; i < n; i++) {
            // Find profit including the current job
            int inclProf = jobs[i].profit;
            int l = binarySearch(jobs, i);
            if (l != -1)
                inclProf += table[l];

            // Store maximum of including and excluding
            table[i] = Math.max(inclProf, table[i - 1]);
        }

        return table[n - 1];
    }

    private int solve(int[][] A) {
        Job[] jobArr = new Job[A.length];
        for (int i = 0; i < A.length; i++) {
            int start = A[i][0], finish = A[i][1], profit = A[i][2];
            Job job = new Job(start, finish, profit);
            jobArr[i] = job;
        }
        return schedule(jobArr);
    }

    public static void main(String[] args) {
        //int[][] A = {{1, 2, 50}, {3, 5, 20}, {6, 19, 100}, {2, 100, 200}};
        int[][] A = {
                {42, 18468, 6335},
                {26501, 19170, 15725},
                {11479, 29359, 26963},
                {24465, 5706, 28146},
                {23282, 16828, 9962},
                {492, 2996, 11943},
                {4828, 5437, 32392},
                {14605, 3903, 154},
                {293, 12383, 17422},
                {18717, 19719, 19896}
        };
        Q3_Weighted_Job_Scheduling solution = new Q3_Weighted_Job_Scheduling();
        int result = solution.solve(A);
        PrintUtils.print(result);
    }
}
