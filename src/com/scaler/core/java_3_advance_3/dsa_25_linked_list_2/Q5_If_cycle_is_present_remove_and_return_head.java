package com.scaler.core.java_3_advance_3.dsa_25_linked_list_2;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 14/10/23
 * @project scaler_course_code
 */
public class Q5_If_cycle_is_present_remove_and_return_head {
    /**
     * Given a linked list if cycle is present,
     * remove the cycle return start of cycle.
     * If cycle is not present, then return null
     * **/
    private static Node checkCycleAndRemove(Node head) {
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
        if (!isCycle) return null;
        // Find the start of the cycle
        Node s1 = head;
        Node s2 = slow; // or fast
        while (s1.val != s2.val) {
            s1 = s1.next;
            s2 = s2.next;
        }
        Node temp = s1; // oe s2;
        while (temp.next.val != s1.val) temp = temp.next;
        temp.next = null; // remove the cycle
        return s1; // or s2
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node6;

        Node result = checkCycleAndRemove(head);
        CreateLinkedList.printLL(result);
    }
}
