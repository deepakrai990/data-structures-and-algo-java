package com.scaler.core.java_3_advance_3.dsa_30_problems_on_stacks_and_queues_and_deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_DequeExample {
    /**
     * A Deque (pronounced "deck") in Java stands for "double-ended queue," and it's an interface
     * that represents a linear collection that supports element insertion and removal at both ends.
     * It extends the Queue interface, which means it supports all the methods provided by
     * the Queue interface and also adds methods to operate on both ends of the queue.
     * * *
     * Here's an explanation of the Deque interface and an example of how to use it:
     * 1. Interface Hierarchy:
     *      * Deque is a sub-interface of Queue.
     *      * It is part of the java.util package.
     * 2. Main Methods:
     *      * addFirst(E e) and addLast(E e): Add an element to the beginning or end of the deque.
     *      * offerFirst(E e) and offerLast(E e): Add an element to the beginning or end of the deque if possible
     *          (returning false if not).
     *      * removeFirst() and removeLast(): Remove and return the first or last element from the deque.
     *      * pollFirst() and pollLast(): Remove and return the first or last element from the deque
     *          (returning null if the deque is empty).
     *      * getFirst() and getLast(): Get the first or last element of the deque without removing it
     *          (throwing an exception if the deque is empty).
     *      * peekFirst() and peekLast(): Get the first or last element of the deque without removing it
     *          (returning null if the deque is empty).
     * 3. Example:
     * **/
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        // Adding elements to the deque
        deque.addFirst("A");
        deque.addLast("B");
        deque.offerFirst("Z");
        deque.offerLast("C");

        System.out.println("Deque: " + deque);
        // Removing and retrieving elements
        System.out.println("First element: " + deque.removeFirst());
        System.out.println("Last element: " + deque.removeLast());
        System.out.println("Updated Deque: " + deque);
    }
    /**
     * In this example:
     *      * We create a Deque using a LinkedList.
     *      * We add elements to the beginning and end of the deque using methods like addFirst and addLast.
     *      * We print the deque to see the order of elements.
     *      * We remove and retrieve the first and last elements using methods like removeFirst and removeLast.
     *      * Finally, we print the updated deque after removal.
     * *
     * The Deque interface is useful when you need to work with a double-ended queue data structure,
     * and it provides a wide range of methods for handling elements at both ends of the queue efficiently.
     * You can choose between different implementations of the Deque interface, such as ArrayDeque or LinkedList,
     * based on your specific requirements and performance characteristics.
     * **/
}
