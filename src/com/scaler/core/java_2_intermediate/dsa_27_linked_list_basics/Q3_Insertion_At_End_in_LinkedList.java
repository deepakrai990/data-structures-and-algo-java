package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 10/10/23
 * @project scaler_course_code
 */
public class Q3_Insertion_At_End_in_LinkedList {
    private static Node insertAtEnd(Node head, int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(16, 12, 15, 20);
        int val = 10;
        Node result = insertAtEnd(head, val);
        CreateLinkedList.printLL(result);
    }
}
