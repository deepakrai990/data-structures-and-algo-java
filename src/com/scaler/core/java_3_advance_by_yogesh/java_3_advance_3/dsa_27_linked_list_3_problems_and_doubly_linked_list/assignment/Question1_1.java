package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_27_linked_list_3_problems_and_doubly_linked_list.assignment;

import com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_25_linked_llst_1_introduction.model.ListNode;

/**
 * @created 02/03/23 1:23 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1_1 {
    public int lPalin(ListNode A) {
        if (A == null) return 0; //If Linked List is empty

        ListNode p1 = A;
        ListNode middle = getMiddle(A); //get the middle of LL
        ListNode p2 = middle.next; //assign middle next element as head of LL 2
        middle.next = null; //Break the linked list

        ListNode rl = reverse(p2); //Reverse the LL

        while (p1 != null && rl != null) {   //Compare val of two LL if not equal return 0 else inc both LL
            if (p1.val == rl.val) {
                p1 = p1.next;
                rl = rl.next;
            } else {
                return 0;
            }
        }
        return 1;
    }


    //Get the middle node of the linked list
    static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //Reverse the given Linked List
    static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
