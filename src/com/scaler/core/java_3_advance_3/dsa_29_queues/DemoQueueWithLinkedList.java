package com.scaler.core.java_3_advance_3.dsa_29_queues;

/**
 * @author Deepak Kumar Rai
 * @created 27/10/23
 * @project scaler_course_code
 */
public class DemoQueueWithLinkedList {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(5);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());
        System.out.println("Rear element: " + queue.rear());

        queue.enqueue(4);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}
