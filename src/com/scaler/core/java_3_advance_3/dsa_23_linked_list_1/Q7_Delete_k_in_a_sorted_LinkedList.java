package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 13/10/23
 * @project scaler_course_code
 */
public class Q7_Delete_k_in_a_sorted_LinkedList {
    /**
     * Delete k in a sorted linked list
     * **/
    private static Node delete(Node head, int k) {
        if (head == null) return head;
        if (head.val == k) {
            head = head.next;
            return head;
        }
        Node current = head;
        while (current.next != null && current.next.val != k) {
            current = current.next;
        }
        if (current.next != null && current.next.val == k) {
            current.next = current.next.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(1, 2, 3, 4, 5, 6, 7);
        CreateLinkedList.printLL(head);

        System.out.println();

        int k = 4;
        Node result = delete(head, k);
        CreateLinkedList.printLL(result);
    }
}
