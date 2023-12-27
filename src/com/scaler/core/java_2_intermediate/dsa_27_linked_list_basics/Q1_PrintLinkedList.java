package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @created 09/10/23 9:20 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_PrintLinkedList {
    private static void printLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(3,6,22,7,8, 1, 5);
        printLL(head);
    }
}
