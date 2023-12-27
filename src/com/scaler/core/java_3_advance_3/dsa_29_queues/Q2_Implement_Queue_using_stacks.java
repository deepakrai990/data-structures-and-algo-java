package com.scaler.core.java_3_advance_3.dsa_29_queues;

/**
 * @author Deepak Kumar Rai
 * @created 29/10/23
 * @project scaler_course_code
 */
public class Q2_Implement_Queue_using_stacks {
    public static void main(String[] args) throws IllegalAccessException {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(7);
        queue.enqueue(9);
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.enqueue(8);
        queue.enqueue(10);
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.enqueue(14);
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.enqueue(14);
        System.out.println("Front element: " + queue.peek());
    }
}
