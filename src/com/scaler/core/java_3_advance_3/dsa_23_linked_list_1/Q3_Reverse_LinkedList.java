package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 12/10/23
 * @project scaler_course_code
 */
public class Q3_Reverse_LinkedList {
    /**
     * Given head of a linked list, reverse linked list & return head.
     * **/
    private static Node reverse(Node head) {
        Node current = head;
        Node rightHand = null;
        while (head != null) {
            current = head;
            head = head.next;
            current.next = rightHand;
            rightHand = current;
        }
        return rightHand;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(2, 4, 6, 8, 10);
        CreateLinkedList.printLL(head);

        System.out.println();

        Node result = reverse(head);
        CreateLinkedList.printLL(result);
    }
}
