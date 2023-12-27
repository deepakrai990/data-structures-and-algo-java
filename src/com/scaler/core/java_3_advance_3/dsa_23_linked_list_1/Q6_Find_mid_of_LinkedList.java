package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 13/10/23
 * @project scaler_course_code
 */
public class Q6_Find_mid_of_LinkedList {
    /**
     * Given head of a linked list find the mid of the list
     * **/
    private static Node mid(Node head) {
        if (head ==  null) return head;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(1, 2, 3, 4, 5, 6, 7);
        CreateLinkedList.printLL(head);

        System.out.println();

        Node result = mid(head);
        CreateLinkedList.printLL(result);
    }
}
