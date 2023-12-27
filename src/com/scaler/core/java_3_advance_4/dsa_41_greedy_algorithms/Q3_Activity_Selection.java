package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 30/11/23
 * @project scaler_course_code
 */
public class Q3_Activity_Selection {
    static class Activity {
        String name;
        int startTime;
        int finishTime;

        public Activity(String name, int startTime, int finishTime) {
            this.name = name;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }
    }
    private static void printMaxActivities(Activity[] activities) {
        Arrays.sort(activities, (a1, a2) -> Integer.compare(a1.finishTime, a2.finishTime));

        System.out.println("Selected Activities:");

        // The first activity is always selected
        int i = 0;
        System.out.println(activities[i].name);

        // Consider the rest of the activities
        for (int j = 1; j < activities.length; j++) {
            // If this activity has a start time greater than or equal to the finish
            // time of the previously selected activity, then select it
            if (activities[j].startTime >= activities[i].finishTime) {
                System.out.println(activities[j].name);
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        // Example activities with start and finish times
        Activity[] activities = {
                new Activity("Yoga", 1, 4),
                new Activity("Problems", 3, 5),
                new Activity("Eating", 0, 6),
                new Activity("Downloading", 5, 7),
                new Activity("Scaler", 8, 9)
        };

        printMaxActivities(activities);
    }
}
