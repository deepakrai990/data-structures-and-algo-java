package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 30/11/23
 * @project scaler_course_code
 */
public class Q4_Job_Scheduling_1 {
    static class Job implements Comparable<Job> {
        char id;
        int deadline;
        int profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        // Sort jobs based on profit in descending order
        @Override
        public int compareTo(Job other) {
            return other.profit - this.profit;
        }
    }
    private static void printMaxProfitJobs(Job[] jobs) {
        Arrays.sort(jobs);

        int n = jobs.length;
        int result[] = new int[n];
        boolean slot[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            // Find a free slot for this job
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = i;
                    slot[j] = true;
                    break;
                }
            }
        }
        // Print the result
        System.out.println("Job Schedule for Maximum Profit:");
        for (int i = 0; i < n; i++) {
            if (slot[i]) {
                System.out.println("Job " + jobs[result[i]].id + " Deadline: " +
                        jobs[result[i]].deadline + " Profit: " + jobs[result[i]].profit);
            }
        }
    }
    public static void main(String[] args) {
        // Example jobs with deadline and profit
        Job[] jobs = {
                new Job('a', 3, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 30)
        };
        printMaxProfitJobs(jobs);
    }
}
