package com.scaler.core.java_3_advance_3.dsa_23_linked_list_1;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;
import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 12/10/23
 * @project scaler_course_code
 */
public class Q2_Insert_into_sorted_LinkedList {
    /**
     * Given head of a sorted linked list, create and insert a new
     * node with data = x, [List should be sorted after insertion]
     * **/
    private static Node insertIntoSorted(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        if (val < head.val) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node current = head;
        while (current.next != null && current.next.val < val) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(3, 6, 10, 14, 20, 24);
        int val = 18;
        CreateLinkedList.printLL(head);

        System.out.println();

        Node result = insertIntoSorted(head, val);
        CreateLinkedList.printLL(result);
    }
}
