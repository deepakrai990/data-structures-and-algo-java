package com.scaler.core.java_3_advance_3.dsa_25_linked_list_2;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_MergeSort_In_LinkedList {
    private static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node mid = mid(head);
        Node head1 = mid.next;
        mid.next = null;
        Node temp1 = mergeSort(head);
        Node temp2 = mergeSort(head1);
        Node temp3 = merge(temp1, temp2);
        return temp3;
    }
    private static Node mid(Node head) {
        if (head == null) return head;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
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
        if (head1 == null)
            temp.next = head2;
        if (head2 == null)
            temp.next = head1;
        return head;
    }
    public static void main(String[] args) {
        Node head = CreateLinkedList.build(1, -2, 6, 3, 2, 7, 9, 4, 7);
        CreateLinkedList.printLL(head);

        System.out.println();
        Node result = mergeSort(head);
        CreateLinkedList.printLL(result);
    }
}
