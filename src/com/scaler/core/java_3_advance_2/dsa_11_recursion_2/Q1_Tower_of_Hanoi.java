package com.scaler.core.java_3_advance_2.dsa_11_recursion_2;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Tower_of_Hanoi {
    /**
     * Problem: Tower of hanoi
     * **/
    private static void  towerOfHanoi(int N, char s, char h, char d) {
        if (N == 0) {
            return;
        }
        towerOfHanoi(N - 1, s, d, h);
        System.out.println("Move disk " + N + " from " + s + " to " + d);
        towerOfHanoi(N - 1, h, s, d);
    }
    // Function to solve the Tower of Hanoi problem
    private static void towerOfHanoi1(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            // Move the single disk from source to destination
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        // Move n-1 disks from source to auxiliary using destination as the auxiliary rod
        towerOfHanoi1(n - 1, source, destination, auxiliary);
        // Move the remaining largest disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        // Move the n-1 disks from auxiliary to destination using a source as the auxiliary rod
        towerOfHanoi1(n - 1, auxiliary, source, destination);
    }
    public static void main(String[] args) {
        int numberOfDisks = 3; // Change this value for different numbers of disks
        // Solve the Tower of Hanoi for the given number of disks
        System.out.println("------------------------------Approach 1------------------------------");
        towerOfHanoi(numberOfDisks, 'A', 'B', 'C');
        System.out.println("------------------------------Approach 2------------------------------");
        towerOfHanoi1(numberOfDisks, 'A', 'B', 'C');
    }
}
