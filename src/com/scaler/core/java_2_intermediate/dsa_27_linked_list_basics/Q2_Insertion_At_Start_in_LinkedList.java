package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 10/10/23
 * @project scaler_course_code
 */
public class Q2_Insertion_At_Start_in_LinkedList {
    private static Node insertAtStart(Node head, int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        return head;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(12, 15, 20);
        Node result = insertAtStart(head, 17);
        CreateLinkedList.printLL(result);
        System.out.println();
    }
}
