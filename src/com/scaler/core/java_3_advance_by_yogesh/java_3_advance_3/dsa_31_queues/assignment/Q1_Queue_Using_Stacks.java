package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_31_queues.assignment;

import java.util.LinkedList;

/**
 * @created 09/03/23 10:28 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Queue_Using_Stacks {
    public static class UserQueue {
        /**
         * Initialize your data structure here.
         */
        public static LinkedList<Integer> q;

        UserQueue() {
            q = new LinkedList();
        }

        /**
         * Push element X to the back of queue.
         */
        static void push(int X) {
            q.add(X);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        static int pop() {
            return q.pop();
        }

        /**
         * Get the front element of the queue.
         */
        static int peek() {
            return q.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        static boolean empty() {
            if (!q.isEmpty())
                return false;
            else
                return true;
        }
    }
}
