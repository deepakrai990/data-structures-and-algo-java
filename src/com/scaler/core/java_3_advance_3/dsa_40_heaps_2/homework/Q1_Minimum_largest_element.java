package com.scaler.core.java_3_advance_3.dsa_40_heaps_2.homework;

import java.util.Comparator;import java.util.PriorityQueue; /**
 * @created 02/04/23 11:25 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Minimum_largest_element {

    /***
     *  As the problem state each time we can pick any element from the array and the same element can be added to the same value.
     *  Meaning suppose the original arr= [1, 3, 5, 7]  and there are 3 step we have to perform
     *
     *  Step1: First we have chosen index-0  i.e. current element 1, so next step it will be (1 + 1) = 2, so the arr= [2, 3, 5, 7]
     *  Step2: Intention will be to choose the smallest from the current state, which is in this case- 2 [index-0]
     *         So the arr will be = [4, 3, 5, 7]
     *  Step3: Intention will be to choose the smallest from the current state, which is in this case- 3 [index-1]
     *         So the arr will be = [4, 6, 5, 7]
     *  So, the Max value from the current state is- 7.
     *
     *  As, we can see, each step if we know the minimum value of the current state and it's original position/index
     *  from which it got derived then we can easily calculate the nextStep
     *  by doing (current value + original value[by using original position/index] )
     *
     *  For that we can use a MinHeap and a variable to keep track of the maxValue of the current state.
     */

    /**
     * Support Pair Class to Hold the Next Step Value and Original Index
     */
    static class Pair {
        int index;
        int nextStateValue;

        public Pair(int index, int nextStateValue) {
            this.index = index;
            this.nextStateValue = nextStateValue;
        }
    }
    public int solve(int[] A, int B) {
        int maxCurrentState = Integer.MIN_VALUE;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair obj1, Pair obj2) {
                if (obj1.nextStateValue > obj2.nextStateValue) {
                    return 1;
                }
                return -1;
            }
        });

        /**
         * Iterate through all the elements and add the next state value.
         * Along with will keep track of the Max Value of the Original State
         */
        for (int i = 0; i < A.length; i++) {
            maxCurrentState = Math.max(maxCurrentState, A[i]);
            minHeap.add(new Pair(i, A[i] + A[i]));
        }

        /**
         * Perform B operations and Keep track of the MaxValue of current state
         */
        for (int i = 0; i < B; i++) {
            Pair currentPair = minHeap.poll();
            int currentStateValue = currentPair.nextStateValue;
            int index = currentPair.index;
            // keep track of the Max Value till now by comparing with the Current State
            maxCurrentState = Math.max(maxCurrentState, currentStateValue);
            // Add the new value in the MinHeap by adding the Original value i.e. A[index] in the currentStateValue
            minHeap.add(new Pair(index, currentStateValue + A[index]));
        }

        return maxCurrentState;
    }
}
