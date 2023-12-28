package com.scaler.core.java_2_intermediate.dsa_06_arrays_carry_forward.homework;

/**
 * @created 12/09/22 11:24 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q8_Bulbs {
    /**
     * Q8. Bulbs
     *
     * Problem Description
     * A wire connects N light bulbs.
     *
     * Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of
     * all the bulbs to the right of the current bulb.
     *
     * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all
     * the bulbs.
     *
     * You can press the same switch multiple times.
     *
     * Note: 0 represents the bulb is off and 1 represents the bulb is on.
     *
     *
     *
     * Problem Constraints
     * 0 <= N <= 5×105
     * 0 <= A[i] <= 1
     *
     *
     *
     * Input Format
     * The first and the only argument contains an integer array A, of size N.
     *
     *
     *
     * Output Format
     * Return an integer representing the minimum number of switches required.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [0, 1, 0, 1]
     * Input 2:
     *
     *  A = [1, 1, 1, 1]
     *
     *
     * Example Output
     * Output 1:
     *
     *  4
     * Output 2:
     *
     *  0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  press switch 0 : [1 0 1 0]
     *  press switch 1 : [1 1 0 1]
     *  press switch 2 : [1 1 1 0]
     *  press switch 3 : [1 1 1 1]
     * Explanation 2:
     *
     *  There is no need to turn any switches as all the bulbs are already on.
     * **/
    private static int bulbs(int[] A) {
        int flag = 1;
        int count = 0;
        for (int a : A){
            if(flag == a)
                continue;
            flag = 1 - flag;
            count++;
        }
        return count;
    }
    /**
     * Scaler Solution
     * Approach
     *
     * Hint 1
     * You will never need to press the same switch twice. Why?
     * Because it is equivalent to not pressing the switch, you will end up with the same state.
     * So we can always solve the problem in at most n switch flips.
     *
     * Solution Approach
     * The order in which you press the switch does not affect the final state.
     *
     * Example:
     *
     * Input : [0 1 0 1]
     *
     * Case 1:
     *     Press switch 0 : [1 0 1 0]
     *     Press switch 1 : [1 1 0 1]
     *
     * Case 2:
     *     Press switch 1 : [0 0 1 0]
     *     Press switch 0 : [1 1 0 1]
     * Therefore we can choose a particular order. To make things easier, let’s go from left to right. At the current
     * position, if the bulb is on, we move to the right, else we switch it on. This works because changing
     * any switch to the right of it will not affect it anymore.
     * **/
    private static int bulbs1(int[] A) {
        int state = 0, ans = 0;

        // state variable will represent the state which we have to change.
        for (int i = 0; i < A.length; i++) {

            if (A[i] == state) {
                ans++;
                // As we will switch this, all the bulbs on right side will also change. So, change state = 1 - state
                state = 1 - state;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1};
        int[] B = {1, 1, 1, 1};
        int bulbs = bulbs(A);
        System.out.println("bulbs : " + bulbs);
        bulbs = bulbs(B);
        System.out.println("bulbs : " + bulbs);
        bulbs = bulbs1(A);
        System.out.println("bulbs : " + bulbs);
    }
}
