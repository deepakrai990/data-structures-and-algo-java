package com.scaler.core.java_3_advance_3.dsa_30_problems_on_stacks_and_queues_and_deque;

/**
 * @author Deepak Kumar Rai
 * @created 03/11/23
 * @project scaler_course_code
 */
public class Q3_MyDequeDemo {
    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<>();

        deque.addLast(1);
        deque.addLast(2);
        deque.addFirst(0);

        System.out.print("Deque elements: ");
        deque.display();

        System.out.println("Size: " + deque.size());

        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());

        System.out.println("Removing the first element: " + deque.removeFirst());
        System.out.print("Updated deque elements: ");
        deque.display();

        System.out.println("Removing the last element: " + deque.removeLast());
        System.out.print("Updated deque elements: ");
        deque.display();
    }

}
