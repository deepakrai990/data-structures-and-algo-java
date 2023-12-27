package com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model;

/**
 * @created 09/10/23 9:27 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class CreateLinkedList {
    public static Node build(int... intArr) {
        Node head = null;
        for (int i = 0; i < intArr.length; i++) {
            head = insertAtEnd(head, intArr[i]);
        }
        return head;
    }
    public static Node insertAtEnd(Node head, int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
            return head;
        }
    }
    public static void printLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
    }
}
