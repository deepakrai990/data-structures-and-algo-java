package com.scaler.core.java_3_advance_3.dsa_25_linked_list_2;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 14/10/23
 * @project scaler_course_code
 */
public class Q4_Cycle_Detection {
    /**
     * Given head node of linked list check for cycle detection
     * **/
    private static boolean checkCycle(Node head) {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                isCycle = true;
                break;
            }
        }
        return isCycle;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        boolean hasCycle = checkCycle(node1);

        if (hasCycle) {
            System.out.println("The linked list has a cycle.");
        } else {
            System.out.println("No cycle found in the linked list.");
        }
    }
}
