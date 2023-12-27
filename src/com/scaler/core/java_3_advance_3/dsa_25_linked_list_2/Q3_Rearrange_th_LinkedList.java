package com.scaler.core.java_3_advance_3.dsa_25_linked_list_2;

import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.CreateLinkedList;
import com.scaler.core.java_2_intermediate.dsa_27_linked_list_basics.model.Node;

/**
 * @author Deepak Kumar Rai
 * @created 14/10/23
 * @project scaler_course_code
 */
public class Q3_Rearrange_th_LinkedList {
    private static Node reorderList(Node head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        //find the middle of the list, and split into two lists.    
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;
        //reverse from the middle to the end
        Node secondHalfReversed = reverse(mid);
        //merge these two lists
        return head = mergeTwoLists(head, secondHalfReversed);
    }

    private static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node head = l1; // head of the list to return
        l1 = l1.next;
        Node p = head; // pointer to form a new list
        // A boolean to track which list we need to extract from. 
        // We alternate between a first and second list.
        boolean curListNum = true;
        while (l1 != null && l2 != null) {
            if (!curListNum) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
            if (curListNum) {
                curListNum = false;
            } else {
                curListNum = true;
            }
        }
        // add the rest of the tail, done!
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return head;
    }

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
        Node head = CreateLinkedList.build(1, 2, 3, 4, 5, 6, 7, 8);
        CreateLinkedList.printLL(head);
        System.out.println();

        Node result = reorderList(head);
        CreateLinkedList.printLL(result);
    }
}
