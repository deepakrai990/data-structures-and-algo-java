package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 29/11/23
 * @project scaler_course_code
 */
public class Q4_Job_Scheduling {
    static class Job {
        char id;
        int deadline;
        int profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    /**
     * To implement Job Scheduling with a greedy algorithm using a min-heap (priority queue) in Java,
     * we can use the PriorityQueue class. The jobs will be sorted based on their deadlines,
     * and the one with the earliest deadline will be at the top of the min-heap. Here's an example:
     * <p></p>
     * In this example, the JobScheduling class contains the scheduleJobs method that
     * uses a min-heap (PriorityQueue) to schedule jobs. The jobs are sorted based on their deadlines,
     * and the min-heap is used to maintain the jobs with the highest profit.
     * The minHeap is initially filled with jobs until its size reaches the deadline of
     * the earliest job. Then, for each subsequent job, if its deadline allows it to be scheduled,
     * and its profit is higher than the job with the least profit in the heap,
     * it is scheduled. The least profitable job is removed from the heap.
     *<p></p>
     * This implementation ensures that jobs are scheduled based on their deadlines and profits,
     * maximizing the overall profit.
     * **/
    private static void scheduleJobs(Job[] jobs) {
        // Sort jobs based on deadlines in ascending order
        java.util.Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1.deadline, j2.deadline));

        PriorityQueue<Job> minHeap = new PriorityQueue<>((j1, j2) -> Integer.compare(j1.profit, j2.profit));

        for (Job job : jobs) {
            // If the min-heap is not full, or the current job's deadline allows it to be scheduled
            if (minHeap.size() < job.deadline) {
                minHeap.offer(job);
            } else {
                // Check if the current job has higher profit than the job with the least profit in the heap
                Job minProfitJob = minHeap.poll();
                if (job.profit > minProfitJob.profit) {
                    minHeap.offer(job);
                } else {
                    minHeap.offer(minProfitJob);
                }
            }
        }
        // Print the scheduled jobs
        System.out.println("Scheduled Jobs:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll().id);
        }
    }
    public static void main(String[] args) {
        Job[] jobs = {
                new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)
        };
        scheduleJobs(jobs);
    }

}
