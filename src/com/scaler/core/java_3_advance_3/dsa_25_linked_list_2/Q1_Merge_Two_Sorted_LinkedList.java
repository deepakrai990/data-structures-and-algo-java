package com.scaler.core.java_3_advance_3.dsa_25_linked_list_2;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 13/10/23
 * @project scaler_course_code
 */
public class Q1_Merge_Two_Sorted_LinkedList {
    /**
     * Given 2 sorted linked list merge & get final sorted list
     * **/
    private static Node merge(Node head1, Node head2) {
        Node head, temp;
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.val < head2.val) {
            head = head1;
            temp = head1;
            head1 = head1.next;
        } else {
            head = head2;
            temp = head2;
            head2 = head2.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        if (head2 == null) { temp.next = head1; }
        if (head1 == null) { temp.next = head2; }
        return head;
    }
    public static void main(String[] args) {
        Node head1 = CreateLinkedList.build(2, 5, 9, 14, 19);
        Node head2 = CreateLinkedList.build(3, 6, 10, 11, 12);
        CreateLinkedList.printLL(head1);
        System.out.println();
        CreateLinkedList.printLL(head2);
        System.out.println();

        Node result = merge(head1, head2);
        CreateLinkedList.printLL(result);
    }
}
