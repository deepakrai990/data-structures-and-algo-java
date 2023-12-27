package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 12/10/23
 * @project scaler_course_code
 */
public class Q4_Reverse_a_LinkedList_of_given_first_K_nodes {
    /**
     * Given head node of a linked list reverse first k nodes.
     * Given K >= 0.
     * **/
    private static Node reverseKNodes(Node head, int k) {
        if (head == null || k <= 1) return head;
        Node th = head; // temporary head
        Node rh = null; // reversed head
        Node current = head;
        int count = k;
        while (count > 0 && head != null) {
            current = head;
            head = head.next;
            current.next = rh;
            rh = current;
            count = count - 1;
        }
        th.next = head;
        return rh;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(1, 2, 3, 4, 5, 6, 7);
        CreateLinkedList.printLL(head);

        System.out.println();

        int k = 4;
        Node result = reverseKNodes(head, k);
        CreateLinkedList.printLL(result);
    }
}
