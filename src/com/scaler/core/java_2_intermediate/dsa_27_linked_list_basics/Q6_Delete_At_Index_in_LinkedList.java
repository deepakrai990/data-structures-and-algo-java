package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 10/10/23
 * @project scaler_course_code
 */
public class Q6_Delete_At_Index_in_LinkedList {
    private static Node deleteAtIndex(Node head, int index) {
        if (index < 0) return head;
        if (index == 0) {
            if (head != null) {
                head = head.next;
            }
        } else {
            int count = 0;
            Node curr = head;
            while (curr != null && count < index - 1) {
                curr = curr.next;
                count++;
            }
            if (curr != null && curr.next != null) {
                curr.next = curr.next.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(16, 12, 15, 20, 7, 76);
        int index = 4;
        Node result = deleteAtIndex(head, index);
        CreateLinkedList.printLL(result);
    }
}
