package com.scaler.core.java_3_advance_4.dsa_53_graphs_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @created 01/04/23 11:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Possibility_of_finishing_1 {
    /**
     * Problem: Given N courses with pre-requisites of each course.
     * Check if it's possible to finish all courses.
     * **/
    private int numCourses;
    private List<List<Integer>> adjacencyList;
    private int[] inDegree;

    public Q1_Possibility_of_finishing_1(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        this.adjacencyList = new ArrayList<>();
        this.inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjacencyList.get(prerequisiteCourse).add(course);
            inDegree[course]++;
        }
    }

    private boolean canFinish() {
        Queue<Integer> queue = new LinkedList<>();
        // Add courses with in-degree 0 to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // Perform topological sorting
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int nextCourse : adjacencyList.get(course)) {
                inDegree[nextCourse]--;
                // If in-degree becomes 0, add to the queue
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        // Check if all courses have in-degree 0
        for (int degree : inDegree) {
            if (degree > 0) {
                return false; // Cycle detected, not possible to finish all courses
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}, {4, 3}};

        Q1_Possibility_of_finishing_1 graph = new Q1_Possibility_of_finishing_1(numCourses, prerequisites);
        boolean canFinish = graph.canFinish();

        if (canFinish) {
            System.out.println("It's possible to finish all courses.");
        } else {
            System.out.println("It's not possible to finish all courses.");
        }
    }
}
