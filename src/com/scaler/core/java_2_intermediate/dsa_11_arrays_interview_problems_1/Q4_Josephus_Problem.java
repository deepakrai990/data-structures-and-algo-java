package com.scaler.core.java_2_intermediate.dsa_11_arrays_interview_problems_1;

/**
 * @author Deepak Kumar Rai
 * @created 03/01/24
 * @project scaler_course_code
 */
public class Q4_Josephus_Problem {
    /**
     * Problem: Josephus Problem
     * N people standing in a circle (clockwise).
     * Person one has a knife. He kills the next person in clockwise direction.
     * He passes the knife to the surviving person in clockwise direction.
     * Repeat the same process unit one survives.
     * Find the last people standing.
     * **/
    public static int findSurvivor(int n) {
        // Base case: when there's only one person, the survivor is at position 1.
        if (n == 1) {
            return 1;
        } else {
            // Recursive case: survivor position for n people is (f(n-1) + 1) % n + 1.
            return (findSurvivor(n - 1) + 1) % n + 1;
        }
    }

    public static void main(String[] args) {
        // Example: n = 5 people in a circle
        int n = 8; // 11
        int survivorPosition = findSurvivor(n);
        System.out.println("The survivor is at position: " + survivorPosition);
    }
}
